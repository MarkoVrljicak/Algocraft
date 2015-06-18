package algocraft.construcciones;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.exception.PoblacionInsuficienteException;
import algocraft.exception.RecursosNegativosException;
import algocraft.exception.UnidadIncompletaException;
import algocraft.factory.UnidadesAbstractFactory;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;

public class CreadorDeUnidades extends DecoradorEdificioBasico {

	protected HashMap<Unidades, UnidadesAbstractFactory> unidadesCreables;
	private Queue<Unidad> unidadesEnCreacion;
	
	
	public CreadorDeUnidades(Construccion construccionDecorada) {
		super(construccionDecorada);
		this.unidadesCreables= new HashMap<Unidades, UnidadesAbstractFactory>();
		this.unidadesEnCreacion = new LinkedList<Unidad>();
	}
	
	public void aniadirUnidadCreable(Unidades nombreUnidad, UnidadesAbstractFactory creador){
		unidadesCreables.put(nombreUnidad, creador);
	}
	
	public Unidad crearUnidad(Unidades unidad) 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		UnidadesAbstractFactory creador = unidadesCreables.get(unidad);
		
		if(!tengoMineralSuficiente(creador))
			throw new MineralInsuficienteException();
		if(!tengoGasSuficiente(creador))
			throw new GasInsuficienteException();
		if(!tengoPoblacionSuficiente(creador))
			throw new PoblacionInsuficienteException();
		
		try {
			this.getDuenio().consumirMineral(creador.getMineralNecesario());
			this.getDuenio().consumirGas(creador.getGasNecesario());
		} catch (RecursosNegativosException e) {
			//contradiccion, tengo suficiente o no llegue aca
			e.printStackTrace();
		}
		Unidad unidadCreada = creador.crearUnidad();
		unidadCreada.setColor(this.getColor());
		this.unidadesEnCreacion.add(unidadCreada);

		return unidadCreada;
	}
	
	private boolean tengoPoblacionSuficiente(UnidadesAbstractFactory creador) {
		final int poblacionDisponible = this.getDuenio().getPoblacionDisponible();
		return (poblacionDisponible >= creador.getPoblacionNecesaria());
	}

	private boolean tengoGasSuficiente(UnidadesAbstractFactory creador) {
		final int gasDisponible = this.getDuenio().getGas();
		return (gasDisponible >= creador.getGasNecesario());
	}

	private boolean tengoMineralSuficiente(UnidadesAbstractFactory creador) {
		final int mineralDisponible = this.getDuenio().getMineral();
		return(mineralDisponible >= creador.getMineralNecesario());
	}

	public boolean puedoCrearUnidad(UnidadesAbstractFactory creador) {
		return (this.tengoGasSuficiente(creador)&&
				this.tengoMineralSuficiente(creador)&&
				this.tengoPoblacionSuficiente(creador));
	}
	
	public boolean unidadEnCreacion() {
		return !unidadesEnCreacion.isEmpty();
	}	
	
	//preguntar si hay unidades en creacion
	public boolean unidadTerminada() {
		return !unidadesEnCreacion.peek().enConstruccion();
	}
	
	//preguntar si la unidad esta terminada
	public Unidad obtenerUnidadCreada() throws UnidadIncompletaException{
		if(this.unidadEnCreacion() && this.unidadTerminada())
			return unidadesEnCreacion.poll();
		else
			throw new UnidadIncompletaException();		
	}	

	public boolean tengoUnidad(Unidades nombreUnidad){
		return unidadesCreables.containsKey(nombreUnidad);
	}
	
	@Override
	public void iniciarTurno() {
		this.edificio.iniciarTurno();
		Unidad primerUnidadEnLista = this.unidadesEnCreacion.peek();
		if(this.unidadEnCreacion() && primerUnidadEnLista.enConstruccion())
			primerUnidadEnLista.disminuirTiempoDeConstruccion();
	}


	@Override
	public boolean soyVolador() {
		return false;
	}

}

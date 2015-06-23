package modelo.construcciones;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.exception.UnidadIncompletaException;
import modelo.factory.UnidadesAbstractFactory;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;

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
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, RecursosNegativosException {
		UnidadesAbstractFactory creador = unidadesCreables.get(unidad);
		
		if(!tengoMineralSuficiente(creador))
			throw new MineralInsuficienteException();
		if(!tengoGasSuficiente(creador))
			throw new GasInsuficienteException();
		if(!tengoPoblacionSuficiente(creador))
			throw new PoblacionInsuficienteException();
		
		
		this.getDuenio().consumirMineral(creador.getMineralNecesario());
		this.getDuenio().consumirGas(creador.getGasNecesario());
		
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
	
	public boolean puedoCrearUnidad(Unidades nombreUnidad) {
		return puedoCrearUnidad(unidadesCreables.get(nombreUnidad));
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
	public void iniciarTurno() throws PropiedadNoEstaEnJuegoException {
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

package algocraft.construcciones;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import algocraft.exception.CondicionesInsuficientesException;
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
	
	public Unidad crearUnidad(Unidades unidad) throws CondicionesInsuficientesException{
		UnidadesAbstractFactory creador = unidadesCreables.get(unidad);
		
		if(puedoCrearUnidad(creador) ){
			
			try {
				this.getDuenio().consumirMineral(creador.getMineralNecesario());
				this.getDuenio().consumirGas(creador.getGasNecesario());
			} catch (RecursosNegativosException e) {
				throw new CondicionesInsuficientesException();
			}
			Unidad unidadCreada = creador.crearUnidad();
			unidadCreada.setColor(this.getColor());
			this.unidadesEnCreacion.add(unidadCreada);
			
			return unidadCreada;
		}
		else 
			throw new CondicionesInsuficientesException();
	}
	
	public boolean puedoCrearUnidad(UnidadesAbstractFactory creador) {
		final int mineralDisponible = this.getDuenio().getMineral();
		final int gasDisponible = this.getDuenio().getGas();
		
		final int poblacionDisponible = this.getDuenio().getPoblacionDisponible();
		
		boolean puedeCrearse = (mineralDisponible >= creador.getMineralNecesario());
		puedeCrearse = puedeCrearse && (gasDisponible >= creador.getGasNecesario());
		puedeCrearse = puedeCrearse && (poblacionDisponible >= creador.getPoblacionNecesaria());
		
		return (puedeCrearse);
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

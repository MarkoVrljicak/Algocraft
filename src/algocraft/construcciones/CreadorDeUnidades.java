package algocraft.construcciones;

import java.util.HashMap;

import algocraft.exception.RecursosNegativosException;
import algocraft.factory.UnidadesAbstractFactory;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;

public class CreadorDeUnidades extends DecoradorEdificioBasico {

	protected HashMap<Unidades, UnidadesAbstractFactory> unidadesCreables;
	
	//creacion
	public CreadorDeUnidades(Construccion construccionDecorada) {
		super(construccionDecorada);
		unidadesCreables= new HashMap<Unidades, UnidadesAbstractFactory>();
	}
	
	public void aniadirUnidadCreable(Unidades nombreUnidad, UnidadesAbstractFactory creador){
		unidadesCreables.put(nombreUnidad, creador);
	}
	
	public Unidad crearUnidad(Unidades unidad){
		UnidadesAbstractFactory creador = unidadesCreables.get(unidad);
		
		if(puedoCrearUnidad(creador) ){
			
			try {
				this.getDuenio().consumirMineral(creador.getMineralNecesario());
				this.getDuenio().consumirGas(creador.getGasNecesario());
			} catch (RecursosNegativosException e) {
				e.printStackTrace();
			}
			
			return creador.crearUnidad();
		}
		else return null;
	}
	
	public boolean puedoCrearUnidad(UnidadesAbstractFactory creador) {
		final Recurso recursosDisponibles = this.getDuenio().getRecursos();
		final int poblacionDisponible = this.getDuenio().getPoblacionDisponible();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= creador.getMineralNecesario());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= creador.getGasNecesario());
		puedeCrearse = puedeCrearse && (poblacionDisponible >= creador.getPoblacionNecesaria());
		
		return (puedeCrearse);
	}
	
	//otros
	
	public boolean tengoUnidad(Unidades nombreUnidad){
		return unidadesCreables.containsKey(nombreUnidad);
	}
	
	@Override
	public void iniciarTurno() {
		this.edificio.iniciarTurno();
	}

	@Override
	public boolean soyVolador() {
		return false;
	}	
}

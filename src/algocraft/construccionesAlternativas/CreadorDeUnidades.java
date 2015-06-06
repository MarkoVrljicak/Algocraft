package algocraft.construccionesAlternativas;


import java.util.ArrayList;

import stats.Recurso;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;

public abstract class CreadorDeUnidades extends DecoradorConstruccion {
	
	protected ArrayList<Unidades> unidadesCreables;
	
	public CreadorDeUnidades(Construccion construccionDecorada) {
		super(construccionDecorada);
		unidadesCreables= new ArrayList<Unidades>();
		this.determinarCreables();
	}

	abstract protected void determinarCreables();//obligo a que determine creables en construccion

	public boolean puedoCrearUnidad(Recurso recursosNecesarios,int poblacionNecesaria) {
		final Recurso recursosDisponibles = this.getDuenio().getRecursos();
		final int poblacionDisponible = this.getDuenio().getPoblacion().disponible();
		
		boolean puedeCrearse = (recursosDisponibles.obtenerMineral() >= recursosNecesarios.obtenerMineral());
		puedeCrearse = puedeCrearse && (recursosDisponibles.obtenerGas() >= recursosNecesarios.obtenerGas());
		puedeCrearse = puedeCrearse && (poblacionDisponible >= poblacionNecesaria);
		
		return puedeCrearse;
	}
	
	abstract public Unidad crearUnidad(Unidades nombreUnidad);
		
	public boolean tengoUnidad(Unidades nombreUnidad){
		return unidadesCreables.contains(nombreUnidad);
	}
}

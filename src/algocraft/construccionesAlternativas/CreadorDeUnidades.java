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

	abstract public boolean puedoCrearUnidad(Unidades nombreUnidad,Recurso recursosDisponible,int poblacionDisponible);
	abstract public Unidad crearUnidad(Unidades nombreUnidad,Recurso recursosDisponible,int poblacionDisponible);
		
	public boolean tengoUnidad(Unidades nombreUnidad){
		return unidadesCreables.contains(nombreUnidad);
	}
}

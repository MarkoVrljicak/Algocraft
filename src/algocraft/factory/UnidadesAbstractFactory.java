package algocraft.factory;

import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;

public abstract class UnidadesAbstractFactory {

	protected Recurso recursosNecesarios;
	protected int poblacionNecesaria;
	public abstract Unidad crearUnidad();
	
	public Recurso getRecursosNecesarios(){
		return recursosNecesarios;
	}
	
	public int getPoblacionNecesaria(){
		return poblacionNecesaria;
	}
}

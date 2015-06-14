package algocraft.factory;

import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;

public abstract class UnidadesAbstractFactory {

	protected Recurso recursosNecesarios;
	protected int poblacionNecesaria;
	public abstract Unidad crearUnidad();
	
	public int getMineralNecesario(){
		return recursosNecesarios.obtenerMineral();
	}
	
	public int getGasNecesario(){
		return recursosNecesarios.obtenerGas();
	}
	
	public int getPoblacionNecesaria(){
		return poblacionNecesaria;
	}
}

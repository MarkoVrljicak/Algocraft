package modelo.factory;

import modelo.stats.Recurso;
import modelo.unidades.Unidad;

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

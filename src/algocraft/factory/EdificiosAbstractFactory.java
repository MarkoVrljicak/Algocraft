package algocraft.factory;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.EnumEdificios;
import algocraft.stats.Recurso;

public abstract class EdificiosAbstractFactory {
	
	protected Recurso recursosNecesarios;
	
	public abstract Construccion crearEdificio();
	public abstract boolean necesitoConstruccionAnterior();
	public abstract EnumEdificios getConstruccionNecesitada();
	
	public Recurso getRecursosNecesarios(){
		return recursosNecesarios;
	}
}

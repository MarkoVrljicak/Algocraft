package modelo.factory;

import modelo.construcciones.Construccion;
import modelo.construcciones.EnumEdificios;
import modelo.stats.Recurso;

public abstract class EdificiosAbstractFactory {
	
	protected Recurso recursosNecesarios;
	protected int vida;
	protected int tiempoDeConstruccion;
	
	public abstract Construccion crearEdificio();
	public abstract boolean necesitoConstruccionAnterior();
	public abstract EnumEdificios getConstruccionNecesitada();
	
	public int getMineralNecesario(){
		return recursosNecesarios.obtenerMineral();
	}
	
	public int getGasNecesario(){
		return recursosNecesarios.obtenerGas();
	}
	
}

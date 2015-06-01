package algocraft.construcciones;

import stats.Vida;
import algocraft.Creable;

public abstract class Construccion implements Creable{

	protected Vida vida = new Vida();
	protected int tiempoDeConstruccion;
	protected String nombre;
	
	public int getVida() {
		return vida.maxima();
	}
	
	public int tiempoDeCreacion() {
		return tiempoDeConstruccion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	abstract public Creable clonar();
	
}

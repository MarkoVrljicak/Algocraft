package algocraft.construcciones;

import algocraft.Creable;
import algocraft.Vida;

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

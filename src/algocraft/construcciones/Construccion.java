package algocraft.construcciones;

import algocraft.Creable;
import algocraft.Vida;

public abstract class Construccion implements Creable{

	protected Vida vidaMaxima = new Vida();
	protected int tiempoDeConstruccion;
	protected String nombre;
	
	public int getVida() {
		return vidaMaxima.puntosDeVida();
	}
	
	public int tiempoDeConstruccion() {
		return tiempoDeConstruccion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	abstract public Creable crear();
	
}

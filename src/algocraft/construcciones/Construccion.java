package algocraft.construcciones;

import algocraft.Creable;
import algocraft.Vida;

public abstract class Construccion implements Creable{

	protected Vida vidaMaxima = new Vida();
	protected int costoMineral;
	protected int costoGas;
	protected int tiempoDeConstruccion;
	protected String nombre;
	
	public int getVida() {
		return vidaMaxima.puntosDeVida();
	}

	public int costoMineral() {
		return costoMineral;
	}

	public int costoGas() {
		return costoGas;
	}

	public int tiempoDeConstruccion() {
		return tiempoDeConstruccion;
	}
	
}

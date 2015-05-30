package algocraft.construcciones;

import algocraft.Creable;
import algocraft.Vida;

public class Construccion implements Creable{

	protected Vida vidamaxima = new Vida();
	protected int costomineral;
	protected int costogas;
	
	public int getVida() {
		return vidamaxima.puntosDeVida();
	}

	public int costoMineral() {
		return costomineral;
	}

	public int costoGas() {
		return costogas;
	}
	
}

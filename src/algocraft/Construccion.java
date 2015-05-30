package algocraft;

public class Construccion {

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

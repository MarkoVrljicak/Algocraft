package algocraft.mapa;

public class Aire extends Terreno {

	public boolean sePuedeCaminar() {
		return false;
	}

	public boolean sePuedeVolar() {
		return true;
	}

	public boolean sePuedeMinar() {
		return false;
	}

	public boolean tieneGas() {
		return false;
	}
	
}

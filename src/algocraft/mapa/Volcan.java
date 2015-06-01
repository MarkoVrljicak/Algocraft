package algocraft.mapa;

public class Volcan extends Terreno {

	public boolean sePuedeCaminar() {
		return false;
	}

	public boolean sePuedeVolar() {
		return false;
	}

	public boolean sePuedeMinar() {
		return false;
	}

	public boolean tieneGas() {
		return true;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}

}

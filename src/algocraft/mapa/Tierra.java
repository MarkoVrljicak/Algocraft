package algocraft.mapa;

public class Tierra extends Terreno {
	public boolean sePuedeCaminar(){
		return true;
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

	public boolean sePuedeEdificar() {
		return true;
	}
}

package algocraft.mapa;

public class Aire extends Terreno {

	public boolean sePuedeCaminar() {
		return false;
	}

	public boolean sePuedeVolar() {
		return true;
	}

	public boolean sePuedeMinar() {
		//las minas y los nexos de minerales validan por aca en lugar de sePuedeEdificar()
		return false;
	}

	public boolean tieneGas() {
		return false;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}
	
}

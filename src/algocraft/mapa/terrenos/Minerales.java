package algocraft.mapa.terrenos;

public class Minerales extends Terreno {

	public boolean sePuedeCaminar() {
		return false;
	}

	public boolean sePuedeVolar() {
		return false;
	}

	public boolean sePuedeMinar() {
		return true;
	}

	public boolean tieneGas() {
		return false;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}

	@Override
	public char dibujar() {
		return 'M';
	}

}

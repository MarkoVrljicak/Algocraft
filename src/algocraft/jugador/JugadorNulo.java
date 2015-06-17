package algocraft.jugador;

import algocraft.construcciones.EnumEdificios;

//para no intervenir con los tests unitarios
public class JugadorNulo implements Usuario {

	

	@Override
	public boolean tieneConstruccion(EnumEdificios nombreEdificio) {
		return true;
	}

	@Override
	public int getPoblacionActual() {
		return 0;
	}

	@Override
	public int getPoblacionDisponible() {
		return 100;
	}

	public int getPoblacionMaxima() {
		return 5;
	}

	@Override
	public int getMineral() {
		return 1000;
	}

	@Override
	public int getGas() {
		return 1000;
	}
	
}

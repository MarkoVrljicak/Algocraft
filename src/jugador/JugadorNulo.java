package jugador;

import algocraft.construccionesAlternativas.EnumEdificios;
import stats.Recurso;

//para no intervenir con los tests unitarios
public class JugadorNulo implements Usuario {

	@Override
	public Recurso getRecursos() {
		return new Recurso(1000,1000);
	}

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
	
}

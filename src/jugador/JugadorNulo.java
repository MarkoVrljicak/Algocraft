package jugador;

import stats.Recurso;


public class JugadorNulo implements Usuario {

	@Override
	public Recurso getRecursos() {
		return new Recurso(0,0);
	}

	@Override
	public boolean tieneConstruccion(String nombreConstruccion) {
		return false;
	}
	
}

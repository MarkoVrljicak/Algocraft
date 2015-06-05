package jugador;

import stats.Poblacion;
import stats.Recurso;

//para no intervenir con los tests unitarios
public class JugadorNulo implements Usuario {

	@Override
	public Recurso getRecursos() {
		return new Recurso(1000,1000);
	}

	@Override
	public boolean tieneConstruccion(String nombreConstruccion) {
		return true;
	}

	@Override
	public Poblacion getPoblacion() {
		return new Poblacion();
	}

	@Override
	public int getPoblacionDisponible() {
		return 100;
	}
	
}

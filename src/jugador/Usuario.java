package jugador;

import stats.Recurso;

public interface Usuario {

	public Recurso getRecursos();
	public int getPoblacionActual();
	public boolean tieneConstruccion(String nombreConstruccion);
	public int getPoblacionDisponible();
}

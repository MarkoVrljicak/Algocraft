package jugador;

import stats.Poblacion;
import stats.Recurso;

public interface Usuario {

	public Recurso getRecursos();
	public Poblacion getPoblacion();//sacar
	public boolean tieneConstruccion(String nombreConstruccion);
	public int getPoblacionDisponible();
}

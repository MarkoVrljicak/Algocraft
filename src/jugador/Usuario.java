package jugador;

import stats.Poblacion;
import stats.Recurso;

//interfaz creada para poder hacer jugador Nulo, no se como nombrarla ni si deberia existir
//pero facilita la sulucion enormemente
public interface Usuario {

	public Recurso getRecursos();
	public Poblacion getPoblacion();
	public boolean tieneConstruccion(String nombreConstruccion);
}

package razas;


import java.util.Collection;
import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.ValidadorDeRecursos;

abstract public class Raza {

	protected HashMap<String, ValidadorDeRecursos> construcciones;
	abstract public String getNombre();
	abstract public Construccion construirConstruccion(Recurso recursosDisponibles, String nombreDeConstruccion);
	abstract public Collection<String> getListaDeConstrucciones();

}

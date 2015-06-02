package razas;


import java.util.Collection;
import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.ValidadorDeCreaciones;

abstract public class Raza {

	protected HashMap<String, ValidadorDeCreaciones> construcciones;
	abstract public String getNombre();
	abstract protected boolean tengoConstruccion(String nombreDeConstruccion);
	abstract public Construccion construirConstruccion(Recurso recursosDisponibles, String nombreDeConstruccion);
	abstract public Collection<String> getListaDeConstrucciones();

}

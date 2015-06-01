package razas;


import java.util.Collection;
import java.util.HashMap;

import algocraft.construcciones.Construccion;
import algocraft.creables.ValidadorDeCreaciones;

abstract public class Raza {

	protected HashMap<String, ValidadorDeCreaciones> construcciones;
	abstract public String getNombre();
	abstract protected boolean tengoConstruccion(String nombreDeConstruccion);
	abstract public Construccion construirConstruccion(int mineralDisponible, int gasDisponible, String nombreDeConstruccion);
	abstract public Collection<String> getListaDeConstrucciones();

}

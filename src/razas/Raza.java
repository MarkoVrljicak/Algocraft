package razas;

import java.util.HashMap;

import algocraft.construcciones.Construccion;
import algocraft.creables.ValidadorDeCreaciones;

abstract public class Raza {

	protected HashMap<String, ValidadorDeCreaciones> construcciones;
	abstract protected boolean tengoConstruccion(String nombreDeConstruccion);
	abstract public Construccion construirConstruccion(int mineralDisponible, int gasDisponible, String nombreDeConstruccion);

}

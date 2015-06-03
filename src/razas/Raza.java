package razas;


import java.util.Collection;
import java.util.HashMap;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.creables.ValidadorDeRecursos;

abstract public class Raza {

	protected String nombre;
	protected HashMap<String, ValidadorDeRecursos> construcciones = new HashMap<String, ValidadorDeRecursos>();;

	public String getNombre(){
		return nombre;
	}

	public boolean tengoConstruccion(String nombreDeConstruccion){
		return construcciones.containsKey(nombreDeConstruccion);
	}
	
	public Construccion construirConstruccion(Recurso recursosDisponibles, String nombreDeConstruccion) {
		
		if (tengoConstruccion(nombreDeConstruccion)){
			
			ValidadorDeRecursos validador = construcciones.get(nombreDeConstruccion);
			return (Construccion) validador.crear(recursosDisponibles);
		}
		
		else {
			return null;
		}
	}
	
	public Collection<String> getListaDeConstrucciones(){
		return construcciones.keySet();
	}
}

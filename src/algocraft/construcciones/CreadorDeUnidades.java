package algocraft.construcciones;

import java.util.HashMap;
import stats.Recurso;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.Unidad;

public abstract class CreadorDeUnidades extends Construccion{
	
	protected HashMap<String, ValidadorDePoblacion> unidades = new HashMap<String, ValidadorDePoblacion>();; 

	protected boolean tengoUnidad(String nombreDeUnidad){
		return unidades.containsKey(nombreDeUnidad);
	}
	
	public Unidad crearUnidad(Recurso recursosDisponibles, String nombreDeUnidad, int poblacionDisponible) {
		
		if (tengoUnidad(nombreDeUnidad)){
			
			ValidadorDePoblacion validador = unidades.get(nombreDeUnidad);
			
			return (Unidad) validador.crear(recursosDisponibles,poblacionDisponible);
		}
		
		else {
			return null;
		}
	}
	
}

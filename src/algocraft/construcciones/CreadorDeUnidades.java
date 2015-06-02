package algocraft.construcciones;

import java.util.Map;

import stats.Recurso;
import algocraft.creables.ValidadorDePoblacion;
import algocraft.unidades.Unidad;

public abstract class CreadorDeUnidades extends Construccion{
	
	protected Map<String, ValidadorDePoblacion> unidades; 

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

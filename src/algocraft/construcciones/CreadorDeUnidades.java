package algocraft.construcciones;

import java.util.Map;

import algocraft.creables.ValidadorDeCreaciones;
import algocraft.unidades.Unidad;

public abstract class CreadorDeUnidades extends Construccion{
	
	protected Map<String, ValidadorDeCreaciones> unidades; 

	protected boolean tengoUnidad(String nombreDeUnidad){
		return unidades.containsKey(nombreDeUnidad);
	}
	
	public Unidad crearUnidad(int mineralDisponible, int gasDisponible, String nombreDeUnidad) {
		
		if (tengoUnidad(nombreDeUnidad)){
			
			ValidadorDeCreaciones validador = unidades.get(nombreDeUnidad);
			
			return (Unidad) validador.crear(mineralDisponible, gasDisponible);
		}
		
		else {
			return null;
		}
	}
	
}

package algocraft.construcciones;

import java.util.Map;

import algocraft.ValidadorDeCreaciones;
import algocraft.unidades.Unidad;

public abstract class CreadorDeUnidades extends Construccion{
	
	protected Map<String, ValidadorDeCreaciones> unidades; 

	private boolean tengoUnidad(String nombreDeUnidad){
		return unidades.containsKey(nombreDeUnidad);
	}
	
	@Override
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

package algocraft.construcciones;

import java.util.HashMap;
import java.util.Map;

import algocraft.Creable;
import algocraft.ValidadorDeCreaciones;
import algocraft.unidades.Marine;
import algocraft.unidades.Unidad;

public class Barraca extends Construccion{

	private Map<String, ValidadorDeCreaciones> unidades; 
	
	public Barraca() {
		this.nombre = "Barraca";
		this.vidaMaxima.setVida(1000);
		this.tiempoDeConstruccion = 12;
		unidades = new HashMap<String, ValidadorDeCreaciones>();
		this.unidades.put("Marine", new ValidadorDeCreaciones(150, 0, (Creable) new Marine() ));
	}
	
	public Creable clonar(){
		return (new Barraca());
	}
	
	public boolean tengoUnidad(String nombreDeUnidad){
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

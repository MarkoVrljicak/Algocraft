package algocraft.construcciones;

import algocraft.Creable;
import algocraft.unidades.Unidad;

public class CentroDeMineral extends Construccion{
	
	public CentroDeMineral() {
		this.nombre = "Centro De Mineral";
		this.vidaMaxima.setVida(500);
	}
	
	public Creable clonar(){
		return (new CentroDeMineral());
	}

	@Override
	public Unidad crearUnidad(int mineralDisponible, int gasDisponible, String nombreDeUnidad) {
		return null;
	}
	
}

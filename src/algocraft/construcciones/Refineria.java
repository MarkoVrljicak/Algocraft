package algocraft.construcciones;

import algocraft.Creable;
import algocraft.unidades.Unidad;

public class Refineria extends Construccion {

	public Refineria() {
		this.nombre = "Refineria";
		this.vidaMaxima.setVida(750);
	}

	@Override
	public Creable clonar() {
		return new Refineria();
	}

	@Override
	public Unidad crearUnidad(int mineralDisponible, int gasDisponible,
			String nombreDeUnidad) {
		return null;
	}
	
}

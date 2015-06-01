package algocraft.construcciones;

import algocraft.Creable;
import algocraft.unidades.Unidad;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vidaMaxima.setVida(1300);
	}

	@Override
	public Creable clonar() {
		return (new PuertoEstelar());
	}

	@Override
	public Unidad crearUnidad(int mineralDisponible, int gasDisponible,
			String nombreDeUnidad) {
		return null;
	}

}

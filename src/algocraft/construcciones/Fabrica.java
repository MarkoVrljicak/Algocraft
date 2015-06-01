package algocraft.construcciones;

import algocraft.Creable;
import algocraft.unidades.Unidad;

public class Fabrica extends CreadorDeUnidades {

	public Fabrica() {
		this.nombre = "Fabrica";
		this.tiempoDeConstruccion = 12;
		this.vidaMaxima.setVida(1250);
	}

	@Override
	public Creable clonar() {
		return (new Fabrica());
	}

	@Override
	public Unidad crearUnidad(int mineralDisponible, int gasDisponible,
			String nombreDeUnidad) {
		return null;
	}
}

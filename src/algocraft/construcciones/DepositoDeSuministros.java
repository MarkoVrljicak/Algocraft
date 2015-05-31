package algocraft.construcciones;

import algocraft.Creable;
import algocraft.unidades.Unidad;

public class DepositoDeSuministros extends Construccion {
	
	public DepositoDeSuministros() {
		this.nombre = "Deposito De Suministros";
		this.vidaMaxima.setVida(500);
	}

	@Override
	public Creable clonar() {
		return (new DepositoDeSuministros());
	}

	@Override
	public Unidad crearUnidad(int mineralDisponible, int gasDisponible,
			String nombreDeUnidad) {
		return null;
	}
	
}

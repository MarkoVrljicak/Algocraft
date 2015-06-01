package algocraft.construcciones;

import algocraft.creables.Creable;

public class NexoMineral extends Construccion {

	public NexoMineral() {
		this.nombre = "Nexo Mineral";
		this.tiempoDeConstruccion = 4;
		this.vida.set(250);
	}
	@Override
	public Creable clonar() {
		
		return new NexoMineral();
	}

}

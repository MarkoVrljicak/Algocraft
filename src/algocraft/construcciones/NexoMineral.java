package algocraft.construcciones;

import algocraft.creables.Creable;

public class NexoMineral extends Construccion {

	public NexoMineral() {
		this.nombre = "Centro De Mineral";
		this.tiempoDeConstruccion = 14;
		this.vida.set(250);
	}
	@Override
	public Creable clonar() {
		// TODO Auto-generated method stub
		return null;
	}

}

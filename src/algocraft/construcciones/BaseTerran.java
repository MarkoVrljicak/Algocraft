package algocraft.construcciones;

import algocraft.creables.Creable;

public class BaseTerran extends Construccion implements Creable {

	public BaseTerran() {
		this.nombre = "Base Terran";
		this.tiempoDeConstruccion = 0;
		this.vida.set(2500);
	}
	
	@Override
	public Creable clonar() {
		// TODO Auto-generated method stub
		return null;
	}

}

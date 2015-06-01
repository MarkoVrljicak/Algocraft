package algocraft.construcciones;

import algocraft.creables.Creable;

public class Refineria extends Construccion {

	public Refineria() {
		this.nombre = "Refineria";
		this.vida.set(750);
		this.tiempoDeConstruccion = 6;
	}

	@Override
	public Creable clonar() {
		return new Refineria();
	}

}

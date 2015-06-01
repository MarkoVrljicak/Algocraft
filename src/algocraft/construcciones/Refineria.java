package algocraft.construcciones;

import algocraft.Creable;

public class Refineria extends Construccion {

	public Refineria() {
		this.nombre = "Refineria";
		this.vidaMaxima.setVida(750);
		this.tiempoDeConstruccion = 6;
	}

	@Override
	public Creable clonar() {
		return new Refineria();
	}

}

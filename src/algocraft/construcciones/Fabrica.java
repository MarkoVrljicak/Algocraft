package algocraft.construcciones;

import algocraft.unidades.Golliat;

public class Fabrica extends Construccion {

	public Fabrica() {
		this.vidamaxima.setVida(1250);
		this.costomineral = 200;
		this.costogas = 100;
	}

	public Golliat crearGolliat() {
		return new Golliat();
	}
}

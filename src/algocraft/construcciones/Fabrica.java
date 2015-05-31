package algocraft.construcciones;

import algocraft.unidades.Golliat;

public class Fabrica extends Construccion {

	public Fabrica() {
		this.nombre = "Fabrica";
		this.vidaMaxima.setVida(1250);
		this.costoMineral = 200;
		this.costoGas = 100;
	}

	public Golliat crearGolliat() {
		return new Golliat();
	}
}

package algocraft.construcciones;

import algocraft.unidades.Marine;

public class Barraca extends Construccion{

	public Barraca() {
		this.nombre = "Barraca";
		this.vidaMaxima.setVida(1000);
		this.costoMineral = 150;
		this.costoGas = 0;
		this.tiempoDeConstruccion = 12;
	}

	public Marine crearMarine() {
		return new Marine();
	}
}

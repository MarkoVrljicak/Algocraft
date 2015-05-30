package algocraft.construcciones;

import algocraft.unidades.Marine;

public class Barraca extends Construccion{
	
	public Barraca() {
		this.vidamaxima.setVida(1000);
		this.costomineral = 150;
		this.costogas = 0;
	}

	public Marine crearMarine() {
		return new Marine();
	}
}

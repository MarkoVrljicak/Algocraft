package algocraft.construcciones;

import algocraft.Creable;

public class Fabrica extends Construccion {

	public Fabrica() {
		this.nombre = "Fabrica";
		this.vidaMaxima.setVida(1250);
	}
	
	public Creable crear(){
		return (new Fabrica());
	}
}

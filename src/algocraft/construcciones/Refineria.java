package algocraft.construcciones;

import algocraft.Creable;

public class Refineria extends Construccion {

	public Refineria() {
		this.nombre = "Refineria";
		this.vidaMaxima.setVida(750);
	}
	
	public Creable crear(){
		return (new Refineria());
	}
	
}

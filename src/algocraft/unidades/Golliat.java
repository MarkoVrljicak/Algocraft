package algocraft.unidades;

import algocraft.Creable;

public class Golliat extends Unidad{

	public Golliat() {
		nombre = "Golliat";
		this.vida.set(125);
	}
	
	public Creable clonar(){
		return new Golliat();
	}
}

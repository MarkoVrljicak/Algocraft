package algocraft.unidades;

import algocraft.Creable;

public class Golliat extends Unidad{

	public Golliat() {
		this.vida.setVida(125);
	}
	
	public Creable clonar(){
		return new Golliat();
	}
}

package algocraft.unidades;

import algocraft.Creable;

public class Marine extends Unidad{

	public Marine() {
		nombre = "Marine";
		this.vida.set(40);
	}
	
	public Creable clonar(){
		return new Marine();
	}

}

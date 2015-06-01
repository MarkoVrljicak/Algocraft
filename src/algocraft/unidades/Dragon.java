package algocraft.unidades;

import algocraft.creables.Creable;

public class Dragon extends Unidad {
	
	public Dragon(){
		nombre="Dragon";
		this.vida.set(100);
	}
	
	
	@Override
	public Creable clonar() {
		
		return new Dragon();
	}

}

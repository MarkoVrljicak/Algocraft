package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.unidades.Unidad;

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

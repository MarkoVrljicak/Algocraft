package algocraft.unidades.protos;

import algocraft.creables.Creable;
import algocraft.unidades.Unidad;

public class Scout extends Unidad {

	public Scout() {
		nombre = "Scout";
		this.vida.set(150);
	}
	
	public Creable clonar(){
		return new Scout();
	}
}

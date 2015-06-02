package algocraft.unidades.terran;

import algocraft.creables.Creable;
import algocraft.unidades.Unidad;

public class Marine extends Unidad{

	public Marine() {
		nombre = "Marine";
		this.vida.set(40);
	}
	
	public Creable clonar(){
		return new Marine();
	}

}

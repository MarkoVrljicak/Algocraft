package algocraft.unidades.terran;

import algocraft.creables.Creable;
import algocraft.unidades.Unidad;

public class Golliat extends Unidad{

	public Golliat() {
		nombre = "Golliat";
		this.vida.set(125);
	}
	
	public Creable clonar(){
		return new Golliat();
	}
}

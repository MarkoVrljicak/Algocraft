package algocraft.unidades.terran;

import algocraft.creables.Creable;
import algocraft.unidades.Unidad;

public class NaveTransporte extends Unidad{

	public NaveTransporte() {
		nombre = "Nave Transporte";
		this.vida.set(150);
	}
	
	public Creable clonar(){
		return new NaveTransporte();
	}
}

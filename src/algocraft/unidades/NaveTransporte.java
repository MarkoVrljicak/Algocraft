package algocraft.unidades;

import algocraft.creables.Creable;

public class NaveTransporte extends Unidad{

	public NaveTransporte() {
		nombre = "Nave Transporte";
		this.vida.set(150);
	}
	
	public Creable clonar(){
		return new NaveTransporte();
	}
}

package algocraft.unidades;

import algocraft.Creable;

public class NaveTransporte extends Unidad{

	public NaveTransporte() {
		this.vida.setVida(150);
	}
	
	public Creable clonar(){
		return new NaveTransporte();
	}
}

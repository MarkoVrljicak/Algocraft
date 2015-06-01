package algocraft.unidades;

import algocraft.creables.Creable;

public class Espectro extends Unidad{

	public Espectro() {
		nombre = "Espectro";
		this.vida.set(120);
	}
	
	public Creable clonar(){
		return new Espectro();
	}
}

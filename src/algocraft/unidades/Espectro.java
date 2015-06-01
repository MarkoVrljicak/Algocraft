package algocraft.unidades;

import algocraft.Creable;

public class Espectro extends Unidad{

	public Espectro() {
		nombre = "Espectro";
		this.vida.setVida(120);
	}
	
	public Creable clonar(){
		return new Espectro();
	}
}

package algocraft.unidades;

import algocraft.Creable;

public class Espectro extends Unidad{

	public Espectro() {
		this.vidaMaxima.setVida(120);
	}
	
	public Creable clonar(){
		return new Espectro();
	}
}

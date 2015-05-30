package algocraft.unidades;

import algocraft.Vida;

public class Unidad {

	protected Vida vidaMaxima = new Vida();
	
	public int getVida() {
		return vidaMaxima.puntosDeVida();
	}
	
}

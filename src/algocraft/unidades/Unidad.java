package algocraft.unidades;

import algocraft.Vida;

public class Unidad {

	protected Vida vidamaxima = new Vida();
	
	public int getVida() {
		return vidamaxima.puntosDeVida();
	}
	
}

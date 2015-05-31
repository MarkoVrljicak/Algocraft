package algocraft.construcciones;

import algocraft.Creable;

public class CentroDeMineral extends Construccion{
	
	public CentroDeMineral() {
		this.nombre = "Centro De Mineral";
		this.vidaMaxima.setVida(500);
	}
	
	public Creable crear(){
		return (new CentroDeMineral());
	}
	
}

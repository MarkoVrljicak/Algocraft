package algocraft.construcciones;

import algocraft.Creable;

public class CentroDeMineral extends Construccion{
	
	public CentroDeMineral() {
		this.nombre = "Centro De Mineral";
		this.tiempoDeConstruccion = 4;
		this.vidaMaxima.setVida(500);
	}
	
	public Creable clonar(){
		return (new CentroDeMineral());
	}

}

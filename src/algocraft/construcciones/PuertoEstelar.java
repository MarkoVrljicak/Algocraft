package algocraft.construcciones;

import algocraft.Creable;

public class PuertoEstelar extends Construccion {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vidaMaxima.setVida(1300);
	}
	
	public Creable crear(){
		return (new PuertoEstelar());
	}

}

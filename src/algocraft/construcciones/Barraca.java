package algocraft.construcciones;

import algocraft.Creable;

public class Barraca extends Construccion{

	public Barraca() {
		this.nombre = "Barraca";
		this.vidaMaxima.setVida(1000);
		this.tiempoDeConstruccion = 12;
	}
	
	public Creable crear(){
		return (new Barraca());
	}

}

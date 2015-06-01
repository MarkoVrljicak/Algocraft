package algocraft.construcciones;

import algocraft.creables.Creable;

public class Asimilador extends Construccion {

	public Asimilador() {
		this.nombre = "Refineria";
		this.vida.set(450);
		this.tiempoDeConstruccion = 5;
	}
	
	
	@Override
	public Creable clonar() {
		
		return new Asimilador();
	}

}

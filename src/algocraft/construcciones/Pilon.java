package algocraft.construcciones;

import algocraft.creables.Creable;

public class Pilon extends Construccion {

	public Pilon() {
		this.nombre = "Pilon";
		this.tiempoDeConstruccion = 5;
		this.vida.set(300);
	}
	
	
	@Override
	public Creable clonar() {
		
		return new Pilon();
	}

}

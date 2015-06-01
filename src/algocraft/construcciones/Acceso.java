package algocraft.construcciones;

import algocraft.creables.Creable;

public class Acceso extends Construccion {

	public Acceso() {
		this.nombre = "Acceso";
		this.vida.set(500);
		this.tiempoDeConstruccion = 8;
	}
	
	
	@Override
	public Creable clonar() {
		// TODO Auto-generated method stub
		return null;
	}

}

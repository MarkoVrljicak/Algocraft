package algocraft.construcciones.protos;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.creables.Creable;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "PuertoEstelar";
		this.vida.set(600);
		this.tiempoDeConstruccion = 10;
	}
	
	@Override
	public Creable clonar() {
		return new PuertoEstelar();
	}

}

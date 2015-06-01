package algocraft.construcciones;

import algocraft.Creable;

public class PuertoEstelar extends CreadorDeUnidades {

	public PuertoEstelar() {
		this.nombre = "Puerto Estelar";
		this.vidaMaxima.setVida(1300);
		this.tiempoDeConstruccion = 10;
	}

	@Override
	public Creable clonar() {
		return (new PuertoEstelar());
	}

}

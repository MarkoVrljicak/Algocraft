package algocraft;

public class Fabrica extends Construccion {

	public Fabrica() {
		this.vidamaxima.setVida(1250);
	}

	public Golliat crearGolliat() {
		return new Golliat();
	}
}

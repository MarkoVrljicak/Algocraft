package algocraft;

public class Barraca extends Construccion{
	
	public Barraca() {
		this.vidamaxima.setVida(1000);
	}

	public Marine crearMarine() {
		return new Marine();
	}
}

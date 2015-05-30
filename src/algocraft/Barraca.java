package algocraft;

public class Barraca {

	private Vida vida = new Vida(1000);
	
	public int getVida(){
		return vida.puntosDeVida();
	}

	public Marine crearMarine() {
		return new Marine();
	}
}

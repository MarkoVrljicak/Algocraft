package stats;

public class Vida implements Daniable {
	
	protected int vidaMaxima;
	protected int vidaActual;
	
	public Vida(){
		//Sin esto vida inicializa como objeto invalido.
		vidaMaxima = 0;
		vidaActual = 0;
	}

	public int max() {
		return vidaMaxima;
	}

	public void set(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
		this.vidaActual = this.vidaMaxima;
	}
	
	public int actual(){
		return vidaActual;
	}
}

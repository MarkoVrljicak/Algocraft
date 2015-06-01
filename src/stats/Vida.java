package stats;

public class Vida {
	
	private int vidaMaxima;
	private int vidaActual;
	
	public Vida(){
		//Sin esto vida inicializa como objeto invalido.
		vidaMaxima = 0;
		vidaActual = 0;
	}

	public int maxima() {
		return vidaMaxima;
	}

	public void setVida(int valor) {
		this.vidaMaxima = valor;
		this.vidaActual = this.vidaMaxima;
	}
	
	public int actual(){
		return vidaActual;
	}
}

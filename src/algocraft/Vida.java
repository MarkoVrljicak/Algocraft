package algocraft;

public class Vida {
	
	private int vidaMaxima;
	private int vidaActual;

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

package stats;

public class Escudo implements Daniable {
	
	private int escudoMaximo;
	private int escudoActual;
	
	public Escudo(){
		this.escudoMaximo = 0;
		this.escudoActual = 0;
	}
	
	public int max(){
		return this.escudoMaximo;
	}

	public void set(int escudoMaximo) {
		this.escudoMaximo = escudoMaximo;
		this.escudoActual = this.escudoMaximo;
	}
	
	public int actual(){
		return escudoActual;
	}
	

}

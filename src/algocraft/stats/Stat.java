package algocraft.stats;

abstract public class Stat {
	
	protected int maximoValor;
	protected int actualValor;
	
	public Stat(int maximoValor){
		this.maximoValor = maximoValor;
		this.actualValor = this.maximoValor;
	}
	
	public int max() {
		return this.maximoValor;
	}

	public int actual() {
		return this.actualValor;
	}
	
	public void disminuir(int cantidad) {
		this.actualValor = this.actualValor - cantidad;
		if (this.actualValor < 0){
			this.actualValor = 0;
		}
	}
	
	public boolean estoyVacio() {
		return (this.actualValor == 0);
	}
	
	abstract public void regenerar();
	
	abstract public void quitarEnergia();

}

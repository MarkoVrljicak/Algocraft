package stats;

public class Stat {
	
	protected int maximoValor;
	protected int actualValor;
	
	public Stat(){
		this.maximoValor = 0;
		this.actualValor = 0;
	}
	
	public int max(){
		return this.maximoValor;
	}

	public void set(int maximoValor) {
		this.maximoValor = maximoValor;
		this.actualValor = this.maximoValor;
	}
	
	public int actual(){
		return actualValor;
	}
	
	public void disminuir(int cantidad){
		this.actualValor = this.actualValor - cantidad;
		
		if (this.actualValor < 0){
			this.actualValor = 0;
		}
	}
	

}

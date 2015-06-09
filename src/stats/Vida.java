package stats;

public class Vida extends Stat {
	protected int maximoValor;
	protected int actualValor;
	
	public Vida(int maximoValor){
		this.maximoValor = maximoValor;
		this.actualValor = this.maximoValor;
	}
	
	@Override
	public int max(){
		return this.maximoValor;
	}
	
	@Override
	public int actual(){
		return actualValor;
	}
	
	@Override
	public void disminuir(int cantidad){
		this.actualValor = this.actualValor - cantidad;
		
		if (this.actualValor < 0){
			this.actualValor = 0;
		}
	}

	@Override
	public boolean estoyVacio() {
		return (this.actualValor == 0);
	}

	@Override
	public void regenerar() {
		//no hace nada
	}
}

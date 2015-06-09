package stats;

public class Movimientos extends Stat{
	protected int maximoValor;
	protected int actualValor;
	
	public Movimientos(int maximoValor){
		this.maximoValor = maximoValor;
		this.actualValor = this.maximoValor;
	}

	@Override
	public int max() {
		return this.maximoValor;
	}

	@Override
	public int actual() {
		return this.actualValor;
	}

	@Override
	public void disminuir(int cantidad) {
		this.actualValor = this.actualValor - cantidad;
		if (this.actualValor < 0){
			this.actualValor = 0;
		}
		
	}
	
	@Override
	public void regenerar() {
		this.actualValor = this.maximoValor;
	}

	@Override
	public boolean estoyVacio() {
		return (this.actualValor == 0);
	}
}

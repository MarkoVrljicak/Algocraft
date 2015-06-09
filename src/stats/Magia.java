package stats;

public class Magia extends Stat{
	protected int maximoValor;
	protected int actualValor;
	private int cantidadRegenerada;
	
	public Magia(int maximoValor, int cantidadRegenerada){
		this.maximoValor = maximoValor;
		this.actualValor = this.maximoValor;
		this.cantidadRegenerada = cantidadRegenerada;
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
	
	public void regenerar(){
		
		this.actualValor = this.actual() + cantidadRegenerada;
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

	@Override
	public boolean estoyVacio() {
		return (this.actualValor == 0);
	}

}

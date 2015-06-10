package stats;

public class Magia extends Stat{
	
	private int cantidadRegenerada;
	
	public Magia(int maximoValor, int cantidadRegenerada){
		super(maximoValor);
		this.cantidadRegenerada = cantidadRegenerada;
	}
	
	public void regenerar(){
		this.actualValor = this.actual() + cantidadRegenerada;
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

}

package stats;

public class Magia extends Stat implements Regenerable{
	
	private int cantidadRegenerada;
	
	public Magia(int cantidad) {
		this.cantidadRegenerada = cantidad;
	}
	
	public void regenerar(){
		
		this.actualValor = this.actual() + cantidadRegenerada;
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

}

package stats;

public class Magia extends Stat implements Regenerable{
	
	public void regenerar(int cantidad){
		
		this.actualValor = this.actual() + cantidad;
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

}

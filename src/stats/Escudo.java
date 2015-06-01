package stats;

public class Escudo extends Stat {

	public void regenerar(int cantidad){
		
		this.actualValor = this.actual() + cantidad;
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

}

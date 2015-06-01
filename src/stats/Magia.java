package stats;

public class Magia extends Stat{
	
	public void regenerar(int cantidad){
		this.actualValor = this.actual() + cantidad;
	}

}

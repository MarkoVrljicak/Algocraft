package stats;

public class Escudo extends Stat implements Regenerable {

	public void regenerar(){
		
		this.actualValor = this.actual() + porcentajeRegenerado();
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

	private int porcentajeRegenerado(){
		return (this.maximoValor * 10)/100; //El escudo regenera el 10% por turno
	}
}

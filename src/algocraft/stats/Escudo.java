package algocraft.stats;

public class Escudo extends Stat {

	protected Stat statProtegido;
	
	public Escudo(int maximoValor, Stat statProtegido){
		super(maximoValor);
		this.statProtegido = statProtegido;
	}
	
	public void regenerar(){
		this.actualValor = this.actual() + porcentajeRegenerado();
		
		if(this.actualValor > this.maximoValor){
			this.actualValor = this.maximoValor;
		}
	}

	private int porcentajeRegenerado(){
		return (this.maximoValor * 10)/100; //El escudo regenera el 10% por turno
	}

	@Override
	public void disminuir(int cantidad) {
		this.actualValor = this.actualValor - cantidad;
		if(this.actualValor < 0){
			statProtegido.disminuir(0-this.actualValor);
			this.actualValor = 0;
		}
	}

	@Override
	public boolean estoyVacio() {
		if(this.actualValor == 0){
			return statProtegido.estoyVacio();
		} else {
			return false;
		}
	}
	
	public int actualProtegida() {
		return this.statProtegido.actual();
	}
}

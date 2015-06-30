package modelo.stats;

public class Escudo extends Stat {
	
	private static final int tiempoDeRetrasoRegeneracion = 2;
	protected Stat statProtegido;
	private int turnosDesdeDisminuido;
	
	public Escudo(int maximoValor, Stat statProtegido){
		super(maximoValor);
		this.statProtegido = statProtegido;
		this.turnosDesdeDisminuido = tiempoDeRetrasoRegeneracion + 1;//empieza regenerandose
	}
	
	public void regenerar(){
		turnosDesdeDisminuido ++;
		if(turnosDesdeDisminuido> tiempoDeRetrasoRegeneracion)
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
		this.turnosDesdeDisminuido = 0;
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
	
	public int maxProtegida() {
		return this.statProtegido.max();
	}

	@Override
	public void quitarEnergia() {
		this.actualValor = 0;
	}
}

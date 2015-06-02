package stats;

public class Recurso {
	
	public int mineral;
	public int gas;

	public Recurso(int cantidadMineral,int cantidadGas){
		this.mineral=cantidadMineral;
		this.gas=cantidadGas;
	}
	
	public int obtenerMineral(){
		return mineral;
	}
	
	public int obtenerGas(){
		return gas;
	}
	
	public void gastarRecurso(Recurso otroRecurso){
		mineral = mineral - otroRecurso.obtenerMineral();
		gas = gas - otroRecurso.obtenerGas();
	}

	public void incrementarRecurso(Recurso otroRecurso) {
		mineral = mineral + otroRecurso.obtenerMineral();
		gas = gas + otroRecurso.obtenerGas();
	}
	
}

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
}

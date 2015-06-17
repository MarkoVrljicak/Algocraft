package algocraft.stats;

import algocraft.exception.RecursosNegativosException;

public class Recurso {
	
	private int mineral;
	private int gas;

	public Recurso(int cantidadMineral,int cantidadGas){
		if(cantidadMineral>=0)
			this.mineral=cantidadMineral;
		else throw new IllegalArgumentException();
		if(cantidadGas>=0)
			this.gas=cantidadGas;
		else throw new IllegalArgumentException();
	}
	
	public int obtenerMineral(){
		return mineral;
	}
	
	public int obtenerGas(){
		return gas;
	}
	
	public void incrementarMineral(int cantidadAIncrementar) {
		mineral += cantidadAIncrementar;		
	}

	public void incrementarGas(int cantidadAIncrementar) {
		gas +=cantidadAIncrementar;
		
	}

	public void consumirMineral(int mineralAConsumir) throws RecursosNegativosException {
		mineral -= mineralAConsumir;
		if(mineral<0) throw new RecursosNegativosException();
	}
	
	public void consumirGas(int gasAConsumir) throws RecursosNegativosException {
		gas -= gasAConsumir;
		if(gas<0) throw new RecursosNegativosException();
	}
	
}

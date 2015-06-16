package algocraft.unidades;

import algocraft.stats.Magia;

abstract public class UnidadMagica extends Unidad {
	
	protected Magia magia;
	protected void inicializar() {
		super.inicializar();
		this.setearMagia();
	}

	abstract protected void setearMagia();
	
	public void iniciarTurno(){
		this.magia.regenerar();
	}
	
	public int getMagiaActual(){
		return this.magia.actual();
	}
	
	public int getMagiaMaxima(){
		return this.magia.max();
	}
	
	
	
}

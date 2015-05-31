package algocraft.unidades;

import algocraft.Creable;
import algocraft.Vida;

public abstract class Unidad implements Creable{

	protected String nombre;
	protected int tiempoDeCreacion;
	protected Vida vidaMaxima = new Vida();
	
	public int getVida() {
		return vidaMaxima.puntosDeVida();
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int tiempoDeCreacion() {
		return tiempoDeCreacion;
	}

	@Override
	abstract public Creable clonar();
	
}

package algocraft.unidades;

import stats.Vida;
import algocraft.creables.Creable;

public abstract class Unidad implements Creable, Movible{

	protected String nombre;
	protected int tiempoDeCreacion;
	protected Vida vida = new Vida();
	
	public int getVida() {
		return vida.max();
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

package algocraft.construcciones;

import algocraft.Creable;
import algocraft.Vida;
import algocraft.unidades.Unidad;

public abstract class Construccion implements Creable{

	protected Vida vidaMaxima = new Vida();
	protected int tiempoDeConstruccion;
	protected String nombre;
	
	public int getVida() {
		return vidaMaxima.puntosDeVida();
	}
	
	public int tiempoDeCreacion() {
		return tiempoDeConstruccion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	abstract public Creable clonar();
	
	abstract public Unidad crearUnidad(int mineralDisponible, int gasDisponible, String nombreDeUnidad);
	
}

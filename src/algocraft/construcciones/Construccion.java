package algocraft.construcciones;

import jugador.Jugador;
import stats.Vida;
import algocraft.construcciones.terran.Actualizable;
import algocraft.creables.Creable;

public abstract class Construccion implements Creable, Actualizable{

	protected Vida vida = new Vida();
	protected int tiempoDeConstruccion;
	protected String nombre;
	public Jugador duenio;
	
	public int getVida() {
		return vida.max();
	}
	
	public int tiempoDeCreacion() {
		return tiempoDeConstruccion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	abstract public Creable clonar();

	public void setDuenio(Jugador jugador) {
		duenio= jugador;		
	}
	
}

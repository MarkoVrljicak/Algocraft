package algocraft.construcciones;

import jugador.Jugador;
import jugador.JugadorNulo;
import jugador.Usuario;
import stats.Vida;
import algocraft.creables.Creable;

public abstract class Construccion implements Creable, Actualizable{

	protected Vida vida = new Vida();
	protected int tiempoDeConstruccion;
	protected String nombre;
	public Usuario duenio = new JugadorNulo();
	
	public int getVida() {
		return vida.actual();
	}
	
	public int tiempoDeCreacion() {
		return tiempoDeConstruccion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	protected void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	abstract public Creable clonar();

	public void setDuenio(Jugador jugador) {
		duenio = jugador;		
	}
	
}

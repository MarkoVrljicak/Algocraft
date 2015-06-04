package construccionesAlternativas;

import jugador.*;
import stats.Vida;

public class Construccion implements Actualizable{

	protected Vida vida = new Vida();
	protected int tiempoDeConstruccion;
	protected Edificio nombre;
	public Usuario duenio = new JugadorNulo();
	
	public Construccion(Edificio nombre, int vidaMaxima, int tiempoDeConstruccion){
		this.nombre= nombre;
		this.vida.set(vidaMaxima);
		this.tiempoDeConstruccion=tiempoDeConstruccion;
	}
	
	
	public int getVida() {
		return vida.actual();
	}
	
		
	public Edificio getNombre(){
		return nombre;
	}
	
	
	private void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	public void setDuenio(Jugador jugador) {
		duenio = jugador;		
	}

	@Override
	public void pasarTurno() {
		this.disminuirTiempoDeConstruccion();		
	}


	public boolean enConstruccion() {
		if(tiempoDeConstruccion==0)
			return false;
		else
			return true;
	}
	
}

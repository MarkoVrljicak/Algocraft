package algocraft.construccionesAlternativas;

import jugador.*;
import stats.Vida;

public class EdificioBasico implements Construccion{

	protected Vida vida = new Vida();
	protected int tiempoDeConstruccion;
	protected Edificios nombre;//enum
	public Usuario duenio = new JugadorNulo();
	
	public EdificioBasico(Edificios nombre, int vidaMaxima, int tiempoDeConstruccion){
		this.nombre= nombre;
		this.vida.set(vidaMaxima);
		this.tiempoDeConstruccion=tiempoDeConstruccion;
	}
	
	//relacionado con interfaz daniable en un futuro(la vida esta para usarla)
	public int getVida() {
		return vida.actual();
	}
	
		
	public Edificios getNombre(){
		return nombre;
	}
	
	
	private void disminuirTiempoDeConstruccion() {
		if (this.tiempoDeConstruccion != 0) {
			this.tiempoDeConstruccion--;
		}
	}
	
	public void setDuenio(Usuario jugador) {
		duenio = jugador;		
	}
	
	public Usuario getDuenio() {
		return duenio;		
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

package modelo.construcciones;

import modelo.Interfaces.Actualizable;
import modelo.Interfaces.Daniable;
import modelo.jugador.Jugador;

public interface Construccion extends Daniable, Actualizable{

	public int getVida();
	public int getVidaMaxima();
	public int getEscudo();
	public int getEscudoMaximo();
	public EnumEdificios getNombre();
	public boolean enConstruccion();
	public Jugador getDuenio();
	public void setDuenio(Jugador jugador);
	public int getPoblacionSumada();
	public int getTiempoConstruccion();
	
}

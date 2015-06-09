package Interfaces;

import algocraft.construccionesAlternativas.EnumEdificios;

public interface Construccion extends Actualizable, Daniable{

	public int getVida();
	public EnumEdificios getNombre();
	public boolean enConstruccion();
	public Usuario getDuenio();
	public void setDuenio(Usuario jugador);
	
}

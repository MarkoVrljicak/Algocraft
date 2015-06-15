package algocraft.construcciones;

import algocraft.Interfaces.Actualizable;
import algocraft.Interfaces.Daniable;
import algocraft.jugador.Jugador;

public interface Construccion extends Daniable, Actualizable{

	public int getVida();
	public EnumEdificios getNombre();
	public boolean enConstruccion();
	public Jugador getDuenio();
	public void setDuenio(Jugador jugador);
	public int getPoblacionSumada();
}

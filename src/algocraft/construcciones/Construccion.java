package algocraft.construcciones;

import algocraft.Interfaces.Actualizable;
import algocraft.Interfaces.Daniable;
import algocraft.jugador.Usuario;

public interface Construccion extends Daniable, Actualizable{

	public int getVida();
	public EnumEdificios getNombre();
	public boolean enConstruccion();
	public Usuario getDuenio();
	public void setDuenio(Usuario jugador);
}

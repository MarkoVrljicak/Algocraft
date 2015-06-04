package algocraft.construccionesAlternativas;

import jugador.Usuario;

public interface Construccion extends Actualizable{

	public int getVida();
	public Edificios getNombre();
	public boolean enConstruccion();
	public Usuario getDuenio();
	
}

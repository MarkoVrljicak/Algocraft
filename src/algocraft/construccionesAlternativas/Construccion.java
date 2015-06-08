package algocraft.construccionesAlternativas;

import jugador.Usuario;

public interface Construccion extends Actualizable{

	public int getVida();
	public EnumEdificios getNombre();
	public boolean enConstruccion();
	public Usuario getDuenio();
	public void setDuenio(Usuario jugador);
	
}

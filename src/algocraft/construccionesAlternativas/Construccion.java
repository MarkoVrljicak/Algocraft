package algocraft.construccionesAlternativas;

import jugador.Usuario;
import algocraft.unidades.Alternativas.Daniable;

public interface Construccion extends Actualizable, Daniable{

	public int getVida();
	public EnumEdificios getNombre();
	public boolean enConstruccion();
	public Usuario getDuenio();
	public void setDuenio(Usuario jugador);
	
}

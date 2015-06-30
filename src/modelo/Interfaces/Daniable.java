package modelo.Interfaces;

import modelo.ataques.Ataques;
import modelo.jugador.Colores;

public interface Daniable {
	
	public int getVida();
	public int getVidaMaxima();
	public int getEscudo();
	public int getEscudoMaximo();
	public void recibirDanio(int cantidadDanio);
	public Ataques comoAtacarme();
	public boolean estoyMuerto();
	public Colores getColor();
}

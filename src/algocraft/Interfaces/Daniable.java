package algocraft.Interfaces;

import algocraft.ataques.Ataques;
import algocraft.jugador.Colores;

public interface Daniable {
	public void recibirDanio(int cantidadDanio);
	public Ataques comoAtacarme();
	public boolean estoyMuerto();
	public Colores getColor();
}

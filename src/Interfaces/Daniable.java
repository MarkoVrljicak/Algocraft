package Interfaces;

import algocraft.ataques.Ataques;

public interface Daniable {
	public void recibirDanio(int cantidadDanio);
	public Ataques comoAtacarme();
	public boolean estoyMuerto();
}

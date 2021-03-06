package modelo.ataques;

import modelo.Interfaces.Daniable;

public class AtaqueNormal{
	private int danioAtaque;
	private int rangoAtaque;
	
	public AtaqueNormal(int danio, int rango){
		danioAtaque = danio;
		rangoAtaque = rango;
		
	}
	
	public boolean ejecutarAtaque(Daniable enemigo, int distancia){
		if (distancia > rangoAtaque || distancia == 0 || danioAtaque == 0) return false;
		
		if (enemigo == null){
			return false;
		} else {
			enemigo.recibirDanio(danioAtaque);
			return true;
		}
		
		
	}
}

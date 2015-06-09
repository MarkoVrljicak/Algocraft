package algocraft.ataques;

import algocraft.unidades.Alternativas.Daniable;

public class AtaqueNormal{
	private int danioAtaque;
	private int rangoAtaque;
	
	public AtaqueNormal(int danio, int rango){
		danioAtaque = danio;
		rangoAtaque = rango;
		
	}
	
	public boolean ejecutarAtaque(Daniable enemigo, int distancia){
		if (distancia > rangoAtaque || distancia == 0) return false;
		
		if (enemigo == null){
			return false; //analizar luego si deberia devolver excepcion.
		} else {
			enemigo.recibirDanio(danioAtaque);
			return true;
		}
		
		
	}
}

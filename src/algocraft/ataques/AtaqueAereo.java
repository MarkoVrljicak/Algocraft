package algocraft.ataques;

import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Alternativas.Daniable;

public class AtaqueAereo extends Ataque{
	private int rango;
	private int danio;
	
	public AtaqueAereo(int danioAereo, int rangoAtaque){
		rango = rangoAtaque;
		danio = danioAereo;
	}
	
	public boolean ejecutarAtaque(Terreno terrenoDestino, int distancia){
		Daniable enemigo = null;
		if (distancia > rango || distancia == 0) return false;
			
		enemigo = (Daniable) terrenoDestino.getContenidoCielo();
		
		if (enemigo == null){
			return false; //analizar luego si deberia devolver excepcion.
		} else {
			enemigo.recibirDanio(danio);
			return true;
		}
		
		
	}
}

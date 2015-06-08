package algocraft.ataques;

import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Alternativas.Daniable;

public class AtaqueTerrestre extends Ataque {
	private int rango;
	private int danio;
	
	public AtaqueTerrestre(int danioTerrestre, int rangoAtaque){
		rango = rangoAtaque;
		danio = danioTerrestre;
	}
	
	public boolean ejecutarAtaque(Terreno terrenoDestino, int distancia){
		Daniable enemigo = null;
		if (distancia > rango || distancia == 0) return false;
			
		enemigo = (Daniable) terrenoDestino.getContenidoSuelo();
		
		if (enemigo == null){
			return false; //analizar luego si deberia devolver excepcion.
		} else {
			enemigo.recibirDanio(danio);
			return true;
		}
		
		
	}
}

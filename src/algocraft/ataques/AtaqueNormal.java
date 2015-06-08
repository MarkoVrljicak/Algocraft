package algocraft.ataques;

import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Daniable;

public class AtaqueNormal extends Ataque{
	private int rango;
	private int danioAire;
	private int danioTierra;
	
	public AtaqueNormal(int rangoAtaque, int danioAereo, int danioTerrestre){
		rango = rangoAtaque;
		danioAire = danioAereo;
		danioTierra = danioTerrestre;	
	}
	
	public boolean ejecutarAtaque(Terreno terrenoDestino, SectoresDeTerreno sector, int distancia){
		Daniable enemigo = null;
		if (distancia > rango || distancia == 0) return false;
		
		if (sector == SectoresDeTerreno.CIELO){
			enemigo = (Daniable) terrenoDestino.getContenidoCielo();
		} else if (sector == SectoresDeTerreno.SUELO){
			enemigo = (Daniable) terrenoDestino.getContenidoSuelo();
		}
		
		if (enemigo == null){
			return false;
		} else {
			if (sector == SectoresDeTerreno.CIELO){
				enemigo.recibirDanio(danioAire);
			} else if (sector == SectoresDeTerreno.SUELO){
				enemigo.recibirDanio(danioTierra);
			}
			return true;
		}
		
		
		
	}
}

package algocraft.mapa;

import algocraft.mapa.terrenos.Terreno;

public class Casillero {
	
	public Coordenada coordenada;
	public Terreno terreno;

	public Casillero(Coordenada unaCoordenada) {
		coordenada=unaCoordenada;
		terreno = null;
	}
	
	protected void setTerreno(Terreno unTerreno){
		terreno = unTerreno;
	}

	public Coordenada getCoordenada() {
		return coordenada;//debreia devolver una copia asi no se puede modificar
	}


	public Terreno getTerreno() {
		return terreno;//debreia devolver una copia asi no se puede modificar
	}
	
}



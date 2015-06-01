package algocraft.mapa;

import algocraft.creables.Creable;

public class Casillero {
	
	public Coordenada coordenada;
	public Creable contenido;
	public Terreno terreno;

	public Casillero(Coordenada unaCoordenada) {
		coordenada=unaCoordenada;
		contenido=null;
		terreno = null;
	}
	
	protected void setTerreno(Terreno unTerreno){
		terreno = unTerreno;
	}

	public boolean estaVacio() {
		return (contenido==null);
	}

	public Coordenada getCoordenada() {
		return coordenada;//debreia devolver una copia asi no se puede modificar
	}
	
	public Object getContenido() {
		return contenido;
	}

	public void almacenar(Creable creable) {
		contenido = creable;		
	}

	public Terreno getTerreno() {
		return terreno;//debreia devolver una copia asi no se puede modificar
	}
	
}



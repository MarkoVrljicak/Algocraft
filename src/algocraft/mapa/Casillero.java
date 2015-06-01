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
	
	public void setTerreno(Terreno unTerreno){
		terreno = unTerreno;
	}

	public boolean estaVacio() {
		return (contenido==null);
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	public Object getContenido() {
		return contenido;
	}

	public void almacenar(Creable creable) {
		contenido = creable;		
	}

	public Terreno getTerreno() {
		return terreno;
	}
	
}



package algocraft.mapa;

public class Casillero {
	
	public Coordenada coordenada;
	public Object contenido;

	public Casillero(Coordenada unaCoordenada) {
		coordenada=unaCoordenada;
		contenido=null;
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

	public void almacenar(Object objeto) {
		contenido= objeto;		
	}
	
}



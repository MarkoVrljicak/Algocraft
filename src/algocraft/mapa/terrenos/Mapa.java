package algocraft.mapa.terrenos;

import java.util.HashMap;
import java.util.Iterator;

import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Casillero;
import algocraft.mapa.Coordenada;

public class Mapa implements Iterable<Casillero>{

	private HashMap<Coordenada, Casillero> casilleros;
	private int ancho;
	private int alto;

	public Mapa(int x, int y) {
		ancho = x;
		alto = y;
		casilleros = new HashMap<Coordenada, Casillero>();

		for (int i = 1; i <= ancho; i++) {
			for (int j = 1; j <= alto; j++) {
				Coordenada nuevaCoordenada = new Coordenada(i, j);
				Casillero nuevoCasillero = new Casillero(nuevaCoordenada);
				casilleros.put(nuevaCoordenada, nuevoCasillero);
			}
		}
	}

	public Casillero obtenerCasillero(Coordenada coordenadaPedida)throws FueraDeLimitesException {
		int x = coordenadaPedida.getX();
		int y = coordenadaPedida.getY();

		if (x <= ancho && y <= alto)
			return casilleros.get(coordenadaPedida);
		else
			throw new FueraDeLimitesException();
	}

	@Override
	public Iterator<Casillero> iterator() {
		
		return casilleros.values().iterator();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}

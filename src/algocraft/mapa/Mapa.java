package algocraft.mapa;

import java.util.HashMap;
import java.util.Iterator;

import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;

public class Mapa implements Iterable<Terreno>{

	private HashMap<Coordenada, Terreno> casilleros;
	private int ancho;
	private int alto;

	public Mapa(int x, int y) {
		ancho = x;
		alto = y;
		casilleros = new HashMap<Coordenada, Terreno>();

		for (int i = 1; i <= ancho; i++) {
			for (int j = 1; j <= alto; j++) {
				setearTerrenoEnCoordenada(Terrenos.TIERRA, i, j);
			}
		}
	}
	
	public void setearTerrenoEnCoordenada(Terrenos terreno, int i, int j){
		Coordenada nuevaCoordenada = new Coordenada(i, j);
		Terreno nuevoTerreno = terreno.crear(i, j);
		casilleros.put(nuevaCoordenada, nuevoTerreno);
	}

	public Terreno obtenerCasillero(Coordenada coordenadaPedida)throws FueraDeLimitesException {
		int x = coordenadaPedida.getX();
		int y = coordenadaPedida.getY();

		if (x <= ancho && y <= alto)
			return casilleros.get(coordenadaPedida);
		else
			throw new FueraDeLimitesException();
	}

	@Override
	public Iterator<Terreno> iterator() {
		
		return casilleros.values().iterator();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}

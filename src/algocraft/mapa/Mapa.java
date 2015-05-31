package algocraft.mapa;

import java.util.HashMap;

import algocraft.exception.FueraDeLimitesException;

public class Mapa {

	private HashMap<Coordenada,Casillero> casilleros;
	private int ancho;
	private int alto;

	public Mapa(int x, int y) {
		ancho = x;
		alto = y;
		casilleros= new HashMap<Coordenada,Casillero>();
		
		for(int i= 1; i<= ancho ; i++ ){
			for(int j = 1; j<=alto; j++ ){
				Coordenada nuevaCoordenada= new Coordenada(i,j);
				Casillero nuevoCasillero= new Casillero(nuevaCoordenada);
				casilleros.put(nuevaCoordenada, nuevoCasillero);	
			}			
		}
	}

	public Casillero obtenerCasillero(Coordenada coordenadaPedida) throws FueraDeLimitesException {
		int x = coordenadaPedida.getX();
		int y = coordenadaPedida.getY();
		
		if( x <= ancho && y<= alto ) 
			return casilleros.get(coordenadaPedida);
		else 
			throw new FueraDeLimitesException();
	}

}

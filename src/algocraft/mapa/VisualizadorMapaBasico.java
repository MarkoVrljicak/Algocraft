package algocraft.mapa;


import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;


public class VisualizadorMapaBasico {
	//no tengo ganas de lidiar ahora con la excepcion asi que la paso para arriba, hay que arreglar
	public void visualizarMapaPorConsola(Mapa mapa) throws FueraDeLimitesException{
		int alto= mapa.getAlto();
		int ancho= mapa.getAncho();
		
		for (int j = 1; j <= alto; j++) {
			for (int i = 1; i <= ancho; i++) {
				Coordenada nuevaCoordenada = new Coordenada(i, j);
				Terreno unCasillero = mapa.obtenerCasillero(nuevaCoordenada);
				//Dibujable terreno= unCasillero.getTerreno();
				System.out.print(unCasillero.dibujar());
				System.out.print(' ');
				if(nuevaCoordenada.getX()==ancho)System.out.println(' ');
			}
		}
	}
}

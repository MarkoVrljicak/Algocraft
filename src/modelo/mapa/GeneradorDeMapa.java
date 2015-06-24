package modelo.mapa;

import java.util.ArrayList;
import java.util.Collection;

import modelo.exception.FueraDeLimitesException;
import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;

public class GeneradorDeMapa {
	//Tamanio minimo para que funcione el algoritmo: 22x22
	private Coordenada posicionBase1;
	private Coordenada posicionBase2;
	
	private Mapa mapaGenerado;
	private int distanciaMinimaABases=3;
	
	public GeneradorDeMapa(int ancho, int alto){
		posicionBase1 = new Coordenada(4, alto -3);
		posicionBase2 = new Coordenada(ancho -3, 4);
		mapaGenerado = new Mapa(ancho, alto);
	}
	
	public Coordenada getPosicionBase1(){
		return posicionBase1;
	}

	public Coordenada getPosicionBase2(){
		return posicionBase2;
	}
	
	public Mapa generar() throws FueraDeLimitesException{
		
		//1) Colocar Recursos
		//6 minerales a distancia 3 de las bases
		colocarRecursoAlRededorDeBase(Terrenos.MINERALES, 8, 3, posicionBase1);
		colocarRecursoAlRededorDeBase(Terrenos.MINERALES, 8, 3, posicionBase2);
		
		//2 volcanes a distancia 3 de las bases
		colocarRecursoAlRededorDeBase(Terrenos.VOLCAN, 2, 3, posicionBase1);
		colocarRecursoAlRededorDeBase(Terrenos.VOLCAN, 2, 3, posicionBase2);
		
		//5 minerales a distancia 5 de las bases
		colocarRecursoAlRededorDeBase(Terrenos.MINERALES, 5, 5, posicionBase1);
		colocarRecursoAlRededorDeBase(Terrenos.MINERALES, 5, 5, posicionBase2);
		
		//2 volcanes a distancia 5 de las bases
		colocarRecursoAlRededorDeBase(Terrenos.VOLCAN, 2, 5, posicionBase1);
		colocarRecursoAlRededorDeBase(Terrenos.VOLCAN, 2, 5, posicionBase2);
		
		
		//3 minerales a distancia 7 de las bases
		colocarRecursoAlRededorDeBase(Terrenos.MINERALES, 3, 7, posicionBase1);
		colocarRecursoAlRededorDeBase(Terrenos.MINERALES, 3, 7, posicionBase2);
		
		//2 volcanes a distancia 7 de las bases
		colocarRecursoAlRededorDeBase(Terrenos.VOLCAN, 2, 7, posicionBase1);
		colocarRecursoAlRededorDeBase(Terrenos.VOLCAN, 2, 7, posicionBase2);
		
		
		//2) Colocar Aire
		colocarAire();
		
		
		return mapaGenerado;
	}

	private void colocarRecursoAlRededorDeBase(Terrenos terreno, int cantidad, int distancia, Coordenada posicionBase) throws FueraDeLimitesException{
		/* Coloca cierta cantidad de cierto recurso a cierta distancia de la coordenada provista */
		
		while (cantidad > 0){
		
			for (int i = 1; i <= mapaGenerado.getAncho() && cantidad > 0  ; i++) {
				for (int j = 1; j <= mapaGenerado.getAlto() && cantidad > 0; j++) {
				
					if (posicionBase.distanciaA(new Coordenada(i, j) ) == distancia && casilleroEsApto(i,j)){
						
						if(Math.random() < 0.2){
							mapaGenerado.setearTerrenoEnCoordenada(terreno, i, j);
							cantidad--;
						}
					}
				
				}
			}
		}
		
	}

	private void colocarAire() throws FueraDeLimitesException{
		int minimaCantidadLagosAire = 2;
		
		while (minimaCantidadLagosAire > 0){
			for (int i = 1; i <= mapaGenerado.getAncho(); i++) {
				for (int j = 1; j <= mapaGenerado.getAlto(); j++) {
				
					if (!estoyEncerrado(i,j) && casilleroEsApto(i,j) && Math.random() < 0.005){
						expandirAireConProbabilidad(i, j, 1, 5);
						minimaCantidadLagosAire--;
					
					}
				}
				
			}
		}
			
	}
	
	private void expandirAireConProbabilidad(int i, int j, double probabilidad, int cantidadAireRestante) throws FueraDeLimitesException{
		/* La probabilidad es del 0 (imposible) a 1 (seguro) */
		
		if(Math.random() < probabilidad && cantidadAireRestante > 0){
		
			mapaGenerado.setearTerrenoEnCoordenada(Terrenos.AIRE, i, j);
			cantidadAireRestante--;
		} else {
			
			return;
		}
		
		
		if ( i+1 < mapaGenerado.getAncho() && casilleroEsApto(i+1, j) ){
			expandirAireConProbabilidad(i+1, j, probabilidad - 0.1, cantidadAireRestante);
		}
		
		if ( j+1 < mapaGenerado.getAlto() && casilleroEsApto(i, j+1)){
			expandirAireConProbabilidad(i, j+1, probabilidad - 0.1, cantidadAireRestante);
		}
		
		if ( (i-1 > 0) && casilleroEsApto(i-1, j) ){
			expandirAireConProbabilidad(i-1, j, probabilidad - 0.1, cantidadAireRestante);
		}
		
		if ( (j-1 > 0) && casilleroEsApto(i, j-1) ){
			expandirAireConProbabilidad(i, j-1, probabilidad - 0.1, cantidadAireRestante);
		}
		
		
	}
	
	private boolean casilleroEsApto(int i, int j) throws FueraDeLimitesException {
		/* Chequea que un casillero no tenga recursos y no este
		 * en el area reservada para las bases */
		Coordenada coordenadaActual = new Coordenada(i, j);
		
		Terreno unCasillero = null;
		unCasillero = mapaGenerado.getTerreno(coordenadaActual);
		
		boolean areaPermitida = true; 
		
		if ( coordenadaActual.distanciaA(posicionBase1) < distanciaMinimaABases ||
				coordenadaActual.distanciaA(posicionBase2) < distanciaMinimaABases ){
			areaPermitida = false;
		}
		
		return (areaPermitida && unCasillero.sePuedeCaminar());
		
	}
	
	private boolean estoyEncerrado(int i, int j) throws FueraDeLimitesException {
		/* Chequea que un casillero no tenga recursos y no este
		 * en el area reservada para las bases */
		Coordenada coordenadaActual = new Coordenada(i, j);
		
		Collection<Terreno> radio = mapaGenerado.obtenerRadioDeCasilleros(1, coordenadaActual);
		Collection<Terreno> caminables = new ArrayList<Terreno>();
		
		for(Terreno unTerreno : radio){
			if(!unTerreno.sePuedeCaminar()){
				caminables.add(unTerreno);
			}
		}
		
		return (caminables.size() > 1);
		
	}

}

package algocraft.mapa;

import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Aire;
import algocraft.mapa.terrenos.Mapa;
import algocraft.mapa.terrenos.Minerales;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Tierra;
import algocraft.mapa.terrenos.Volcan;

public class GeneradorDeMapa {
	//Tamanio minimo para que funcione el algoritmo: 20x20
	int anchoDefault = 20;
	int altoDefault = 20;
	Coordenada posicionBase1;
	Coordenada posicionBase2;
	
	private Mapa mapaGenerado;
	
	public GeneradorDeMapa(){
		posicionBase1 = new Coordenada(4, altoDefault -5);
		posicionBase2 = new Coordenada(anchoDefault -5, 4);
		mapaGenerado = new Mapa(20, 20);
	}
	
	public Mapa generar(){
		//1) Llenar de Tierra
		llenarDeTierra();
		

		
		//2) Colocar Recursos
		//6 minerales a distancia 3 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 8, 3, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 8, 3, posicionBase2);
		
		//2 volcanes a distancia 3 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 3, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 3, posicionBase2);
		
		//5 minerales a distancia 5 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 5, 5, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 5, 5, posicionBase2);
		
		//2 volcanes a distancia 5 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 5, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 5, posicionBase2);
		
		
		//3 minerales a distancia 7 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 3, 7, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 3, 7, posicionBase2);
		
		//2 volcanes a distancia 7 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 7, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 7, posicionBase2);
		
		//2 minerales a distancia 15 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 2, 15, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 2, 15, posicionBase2);
		
		//2 volcanes a distancia 15 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 15, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 15, posicionBase2);
		
		//3) Colocar Aire
		colocarAire();
		
		
		return mapaGenerado;
	}
	
	private void llenarDeTierra() {

		for (int i = 1; i <= mapaGenerado.getAncho(); i++) {
			for (int j = 1; j <= mapaGenerado.getAlto(); j++) {
				this.setearTerrenoEnCasillero(new Tierra(), i, j);
			}
		}
	}
	

	private void colocarRecursoAlRededorDeBase(Terreno recurso, int cantidad, int distancia, Coordenada posicionBase){
		/* Coloca cierta cantidad de cierto recurso a cierta distancia de la coordenada provista */
		
		while (cantidad > 0){
		
			for (int i = 1; i <= mapaGenerado.getAncho(); i++) {
				for (int j = 1; j <= mapaGenerado.getAlto(); j++) {
				
					if (posicionBase.distanciaA(new Coordenada(i, j) ) == distancia && casilleroEsCaminable(i,j)){
						
						if(Math.random() < 0.2){
							this.setearTerrenoEnCasillero(recurso, i, j);
							cantidad--;
						}
					}
				
				}
			}
		}
		
	}

	private void colocarAire(){
		int minimaCantidadLagosAire = 2;
		
		while (minimaCantidadLagosAire > 0){
			for (int i = 1; i <= mapaGenerado.getAncho(); i++) {
				for (int j = 1; j <= mapaGenerado.getAlto(); j++) {
				
					if (casilleroEsCaminable(i,j) && Math.random() < 0.01){
						expandirAireConProbabilidad(i, j, 1, 5);
						minimaCantidadLagosAire--;
					
					}
				}
				
			}
		}
			
	}
	
	private void expandirAireConProbabilidad(int i, int j, double probabilidad, int cantidadAireRestante){
		/* La probabilidad es del 0 (imposible) a 1 (seguro) */
		
		if(Math.random() < probabilidad && cantidadAireRestante > 0){
		
			this.setearTerrenoEnCasillero(new Aire(), i, j);
			cantidadAireRestante--;
		} else {
			
			return;
		}
		
		
		if ( i+1 < mapaGenerado.getAncho() && casilleroEsCaminable(i+1, j) ){
			expandirAireConProbabilidad(i+1, j, probabilidad - 0.1, cantidadAireRestante);
		}
		
		if ( j+1 < mapaGenerado.getAlto() && casilleroEsCaminable(i, j+1)){
			expandirAireConProbabilidad(i, j+1, probabilidad - 0.1, cantidadAireRestante);
		}
		
		if ( (i-1 > 0) && casilleroEsCaminable(i-1, j) ){
			expandirAireConProbabilidad(i-1, j, probabilidad - 0.1, cantidadAireRestante);
		}
		
		if ( (j-1 > 0) && casilleroEsCaminable(i, j-1) ){
			expandirAireConProbabilidad(i, j-1, probabilidad - 0.1, cantidadAireRestante);
		}
		
		
	}

	
	private void setearTerrenoEnCasillero(Terreno unTerreno, int i, int j) {
		Coordenada unaCoordenada = new Coordenada(i, j);
		try {
			Casillero unCasillero = mapaGenerado.obtenerCasillero(unaCoordenada);
			unCasillero.setTerreno(unTerreno);
		} catch (FueraDeLimitesException e) {
			// no deberia pasar
			e.printStackTrace();
		}
	}
	
	private boolean casilleroEsCaminable(int i, int j) {
		Coordenada unaCoordenada = new Coordenada(i, j);
		Casillero unCasillero;
		try {
			unCasillero = mapaGenerado.obtenerCasillero(unaCoordenada);
			return unCasillero.getTerreno().sePuedeCaminar();
		} catch (FueraDeLimitesException e) {
			e.printStackTrace();
			return false; //no se como mas arreglarlo
		}
		
		
	}

}

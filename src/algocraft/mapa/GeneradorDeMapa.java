package algocraft.mapa;

import algocraft.exception.FueraDeLimitesException;

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
		//8 minerales a distancia 3 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 8, 3, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 8, 3, posicionBase2);
		
		//2 volcanes a distancia 3 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 3, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 3, posicionBase2);
		
		//6 minerales a distancia 5 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 6, 5, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 6, 5, posicionBase2);
		
		//3 volcanes a distancia 5 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 3, 5, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 3, 5, posicionBase2);
		
		//4 minerales a distancia 7 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 4, 7, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 4, 7, posicionBase2);
		
		//3 volcanes a distancia 7 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 3, 7, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 3, 7, posicionBase2);
		
		//2 minerales a distancia 15 de las bases
		colocarRecursoAlRededorDeBase(new Minerales(), 2, 15, posicionBase1);
		colocarRecursoAlRededorDeBase(new Minerales(), 2, 15, posicionBase2);
		
		//2 volcanes a distancia 15 de las bases
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 15, posicionBase1);
		colocarRecursoAlRededorDeBase(new Volcan(), 2, 15, posicionBase2);
		
		
		//3) Colocar Aire
		//
		//colocarAire();
		
		return mapaGenerado;
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

	private void llenarDeTierra() {

		for (int i = 1; i <= mapaGenerado.getAncho(); i++) {
			for (int j = 1; j <= mapaGenerado.getAlto(); j++) {
				this.setearTerrenoEnCasillero(new Tierra(), i, j);
			}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; //no se como mas arreglarlo
		}
		
		
	}

}

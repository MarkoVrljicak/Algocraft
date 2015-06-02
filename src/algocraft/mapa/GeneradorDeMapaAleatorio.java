package algocraft.mapa;

import java.util.Iterator;


import algocraft.exception.FueraDeLimitesException;
//command
public class GeneradorDeMapaAleatorio {
	
	//variables para tamanio del mapa
	private static final double proporcion =((double)2) / 3;
	private static final int escala = 30;//tamanio del ancho
	private int ancho;
	private int alto;
	//variables para modificar relacion tierra aire
	//las pongo aca para su rapida modificacion y por que son constantes
	private final double probabilidadTierra= 0.55;
	private final int condicionMuerte= 4;//si no tengo estos vecinos muero
	private final int condicionNacimiento= 8;//si tengo nazco
	private final int cantidadIteraciones=5;
	
	private Mapa mapa;
	
	private int calcularAncho() {
		ancho = escala;
		return ancho;
	}

	private int calcularAlto() {
		alto = (int) Math.round( ( (double)escala )  * proporcion);
		return alto;
	}
	
	public Mapa generarMapaAleatorio(){
		mapa = new Mapa(this.calcularAncho(), this.calcularAlto());
		
		this.llenarDeAireYTierraAlAzar();
		for(int iteracion=1 ; iteracion<=cantidadIteraciones ; iteracion++){
			this.iterarSobreElMapa();
		}
		/*
		this.poscicionarBases();
		this.posicionarRecursos();
		*/
		return mapa;
	}

	private void llenarDeAireYTierraAlAzar() {
		Iterator<Casillero> it= mapa.iterator();
		while(it.hasNext()){
			Casillero unCasillero = it.next();
			if(Math.random()<probabilidadTierra) unCasillero.setTerreno( new Tierra() );
			else unCasillero.setTerreno(new Aire() );
		}
	}
	
	private void iterarSobreElMapa(){
		for (int j = 1; j <= alto; j++) {
			for (int i = 1; i <= ancho; i++) {
				Coordenada unaCoordenada = new Coordenada(i, j);
				int cantidadVecinos =contarVecinosConTierra(unaCoordenada);
				try {
					Casillero unCasillero=mapa.obtenerCasillero(unaCoordenada);
					if( casilleroVivo(unCasillero) && (cantidadVecinos<=condicionMuerte)  ) unCasillero.setTerreno(new Aire());
					//else if(cantidadVecinos>condicionNacimiento) unCasillero.setTerreno(new Tierra());
				} catch (FueraDeLimitesException e) {
					e.printStackTrace();
				}
				
			}
		}
				
	}
	
	//TO DO: armar un algoritmo de verdad, que no se valla de rango y no pregunte clase
	private int contarVecinosConTierra(Coordenada unaCoordenada) {
		int x= unaCoordenada.getX();
		int y= unaCoordenada.getY();
		int cantidadVecinos=-1;//se va a contar a si mismo
		for (int j = y-1; j <= y+1; j++) {
			for (int i = x-1; i <= x+1; i++) {
				Coordenada nuevaCoordenada = new Coordenada(i, j);
				try {
					Casillero unCasillero=mapa.obtenerCasillero(nuevaCoordenada);
					if(casilleroVivo(unCasillero)) cantidadVecinos++;
				} catch (FueraDeLimitesException e) {};
				
			}
		}
		return cantidadVecinos;
	}
	
	private boolean casilleroVivo(Casillero unCasillero) {
		if(!( unCasillero==null))
			return unCasillero.getTerreno().getClass().isInstance(Tierra.class);
		else 
			return false;
	}
	
}

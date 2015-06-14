package algocraft;


import Propiedad.Propiedad;
import algocraft.Interfaces.Actualizable;
import algocraft.construcciones.Construccion;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.mapa.Coordenada;
import algocraft.mapa.GeneradorDeMapa;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.razas.Raza;

public class Juego {
	
	private Jugador jugador1;
	@SuppressWarnings("unused")
	private Jugador jugador2;
	private Jugador jugadorActual;
	private Mapa mapa;
	
	public Juego(int ancho , int alto){
		GeneradorDeMapa generador = new GeneradorDeMapa(ancho, alto);
		mapa = generador.generar();
	}

	public void setJugador1(String nombre, Raza unaRaza , Colores unColor) {
		this.jugador1 = new Jugador(nombre, unaRaza, unColor);		
	}
	
	public void setJugador2(String nombre, Raza unaRaza , Colores unColor) {
		this.jugador2 = new Jugador(nombre, unaRaza, unColor);		
	}

	public void iniciarJuego() {
		jugadorActual = jugador1 ; 		
	}
	
	public Terreno obtenerTerreno(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return mapa.getTerreno(coordenada);
	}
	
	public Actualizable seleccionarSuelo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return mapa.getPropiedadSuelo(coordenada);
	}

	public void construirEn(EnumEdificiosTerran edificio, Coordenada coordenada) 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Construccion edificioNuevo = jugadorActual.construir(edificio);
		mapa.almacenar((Propiedad) edificioNuevo, coordenada);
	}

	

	

}

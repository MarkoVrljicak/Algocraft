package algocraft.mapa.terrenos;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;
import algocraft.mapa.Coordenada;

public class Aire extends Terreno {
	
	public Aire(Coordenada posicion){
		coordenada = posicion;
		contenidoSuelo = null;
		contenidoCielo = null;
	}
	
	public void almacenarEnSuelo(Creable creable) throws PosicionInvalidaException{
		throw new PosicionInvalidaException();
	}
	
	public Creable getContenidoSuelo(){
		return contenidoSuelo;
	}
	
	public Creable getContenidoCielo(){
		return contenidoCielo;
	}

	public boolean sePuedeCaminar() {
		return false;
	}

	public boolean sePuedeMinar() {
		return false;
	}

	public boolean tieneGas() {
		return false;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}

	@Override
	public char dibujar() {
		return 'A';
	}
	
}

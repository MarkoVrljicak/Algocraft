package algocraft.mapa.terrenos;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;
import algocraft.mapa.Coordenada;

public class Volcan extends Terreno {
	
	public Volcan(Coordenada posicion){
		contenidoSuelo = null;
		contenidoCielo = null;
		coordenada = posicion;
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
		return true;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}

	@Override
	public char dibujar() {
		return 'V';
	}

}

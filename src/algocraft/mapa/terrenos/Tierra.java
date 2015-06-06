package algocraft.mapa.terrenos;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;

public class Tierra extends Terreno {
	
	public Tierra(){
		contenidoSuelo = null;
		contenidoCielo = null;
	}
	
	public void almacenarEnSuelo(Creable creable) throws PosicionInvalidaException{
		if (!this.sePuedeVolar()){
			throw new PosicionInvalidaException();
		} else {
			contenidoSuelo = creable;
		}
	}
	
	public Creable getContenidoSuelo(){
		return contenidoSuelo;
	}
	
	public Creable getContenidoCielo(){
		return contenidoCielo;
	}
	
	public boolean sePuedeCaminar(){
		return (contenidoSuelo == null);
	}
	
	public boolean sePuedeMinar() {
		return false;
	}

	public boolean tieneGas() {
		return false;
	}

	public boolean sePuedeEdificar() {
		return true;
	}

	@Override
	public char dibujar() {
		return 'T';
	}
}

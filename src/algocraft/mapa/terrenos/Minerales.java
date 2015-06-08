package algocraft.mapa.terrenos;

import algocraft.construccionesAlternativas.Actualizable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;

public class Minerales extends Terreno {
	
	public Minerales(Coordenada posicion){
		nombre = Terrenos.MINERALES;
		coordenada = posicion;
		contenidoSuelo = null;
		contenidoCielo = null;
	}
	
	public void almacenarEnSuelo(Actualizable actualizable) throws DestinoInvalidoException{
		throw new DestinoInvalidoException();
	}
	
	public Actualizable getContenidoSuelo(){
		return contenidoSuelo;
	}
	
	public Actualizable getContenidoCielo(){
		return contenidoCielo;
	}

	public boolean sePuedeCaminar() {
		return false;
	}

	public boolean sePuedeMinar() {
		return true;
	}

	public boolean tieneGas() {
		return false;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}

	@Override
	public char dibujar() {
		return 'M';
	}

}

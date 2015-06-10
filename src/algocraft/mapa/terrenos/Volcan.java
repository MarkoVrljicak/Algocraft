package algocraft.mapa.terrenos;

import algocraft.Interfaces.Actualizable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;

public class Volcan extends Terreno {
	
	public Volcan(Coordenada posicion){
		nombre = Terrenos.VOLCAN;
		contenidoSuelo = null;
		contenidoCielo = null;
		coordenada = posicion;
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

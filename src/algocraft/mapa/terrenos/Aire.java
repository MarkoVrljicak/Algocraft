package algocraft.mapa.terrenos;

import algocraft.Interfaces.Actualizable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;

public class Aire extends Terreno {
	
	public Aire(Coordenada posicion){
		nombre = Terrenos.AIRE;
		coordenada = posicion;
		contenidoSuelo = null;
		contenidoCielo = null;
	}
	
	public void almacenarEnSuelo(Actualizable Actualizable) throws DestinoInvalidoException{
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

package algocraft.mapa.terrenos;

import algocraft.creables.Creable;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;

public class Tierra extends Terreno {
	
	public Tierra(Coordenada posicion){
		nombre = Terrenos.TIERRA;
		contenidoSuelo = null;
		contenidoCielo = null;
		coordenada = posicion;
	}
	
	public void almacenarEnSuelo(Creable creable) throws DestinoInvalidoException{
		if (!this.sePuedeCaminar()){
			throw new DestinoInvalidoException();
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

package modelo.mapa.terrenos;

import modelo.exception.DestinoInvalidoException;
import modelo.mapa.Coordenada;
import modelo.propiedad.Propiedad;

public class Tierra extends Terreno {
	
	public Tierra(Coordenada posicion){
		nombre = Terrenos.TIERRA;
		contenidoSuelo = null;
		contenidoCielo = null;
		coordenada = posicion;
	}
	
	public void almacenarEnSuelo(Propiedad propiedad) throws DestinoInvalidoException{
		if (!this.sePuedeCaminar()){
			throw new DestinoInvalidoException();
		} else {
			contenidoSuelo = propiedad;
		}
	}
	
	public Propiedad getContenidoSuelo(){
		return contenidoSuelo;
	}
	
	public Propiedad getContenidoCielo(){
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

}

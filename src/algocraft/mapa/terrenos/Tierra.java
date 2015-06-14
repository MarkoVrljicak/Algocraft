package algocraft.mapa.terrenos;

import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.propiedad.Propiedad;

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

	@Override
	public char dibujar() {
		return 'T';
	}
}

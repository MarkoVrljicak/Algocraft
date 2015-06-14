package algocraft.mapa.terrenos;

import Propiedad.Propiedad;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;

public class Minerales extends Terreno {
	
	public Minerales(Coordenada posicion){
		nombre = Terrenos.MINERALES;
		coordenada = posicion;
		contenidoSuelo = null;
		contenidoCielo = null;
	}
	
	public void almacenarEnSuelo(Propiedad actualizable) throws DestinoInvalidoException{
		throw new DestinoInvalidoException();
	}
	
	public Propiedad getContenidoSuelo(){
		return contenidoSuelo;
	}
	
	public Propiedad getContenidoCielo(){
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

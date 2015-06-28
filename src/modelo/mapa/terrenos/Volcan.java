package modelo.mapa.terrenos;

import modelo.construcciones.RecolectorGas;
import modelo.exception.DestinoInvalidoException;
import modelo.mapa.Coordenada;
import modelo.propiedad.Propiedad;

public class Volcan extends Terreno {
	
	public Volcan(Coordenada posicion){
		nombre = Terrenos.VOLCAN;
		contenidoSuelo = null;
		contenidoCielo = null;
		coordenada = posicion;
	}
	
	public void almacenarEnSuelo(Propiedad propiedad) throws DestinoInvalidoException{
		try{
			RecolectorGas recolector = (RecolectorGas) propiedad;
			if(contenidoSuelo != null)
				throw new DestinoInvalidoException();
			else
				contenidoSuelo = recolector;				
		}catch(ClassCastException e){
			throw new DestinoInvalidoException();
		}
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
		return false;
	}

	public boolean tieneGas() {
		return true;
	}
	
	public boolean sePuedeEdificar() {
		return false;
	}


}

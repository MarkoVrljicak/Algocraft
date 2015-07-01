package modelo.magias;

import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;

abstract public class AtaqueMagico {
	abstract public void ejecutar() throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion;
	abstract public boolean caduco();
	
	protected void afectarZona(Terreno terreno, int danio){
		Propiedad propiedad = terreno.getContenidoSuelo();
		if(propiedad != null){
			propiedad.recibirDanio(danio);
		}
		propiedad = terreno.getContenidoCielo();
		if(propiedad != null){
			propiedad.recibirDanio(danio);
		}
	}
	
}

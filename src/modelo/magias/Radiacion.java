package modelo.magias;

import java.util.Collection;
import java.util.Iterator;

import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.mapa.Coordenada;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.unidades.Unidad;

public class Radiacion extends AtaqueMagico{
	
	Unidad unidad;
	Mapa mapa;
	public Radiacion(Unidad unidad, Mapa mapa){
		this.unidad = unidad;
		this.mapa = mapa;
	}
	
	public void ejecutar() throws PropiedadNoEstaEnJuegoException{
		int danio = 10;
		Coordenada posicionUnidad = null;
		
		posicionUnidad = mapa.getPosicionPropiedad(unidad);
		
		Collection<Terreno> zonaRadioactiva = mapa.obtenerRadioDeCasilleros(1, posicionUnidad);
		Iterator<Terreno> iter = zonaRadioactiva.iterator();
		while(iter.hasNext()){
			afectarZona(iter.next(), danio);
		}
		
	}

	@Override
	public boolean caduco() {
		return unidad.estoyMuerto();
	}
}

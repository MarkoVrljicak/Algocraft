package algocraft.magias;

import java.util.Collection;
import java.util.Iterator;

import algocraft.exception.PropiedadNoEstaEnJuegoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;

public class Radiacion extends AtaqueMagico{
	
	Unidad unidad;
	Mapa mapa;
	public Radiacion(Unidad unidad, Mapa mapa){
		this.unidad = unidad;
		this.mapa = mapa;
	}
	
	public void ejecutar(){
		Coordenada posicionUnidad = null;
		
		try {
			posicionUnidad = mapa.getPosicionPropiedad(unidad);
		} catch (PropiedadNoEstaEnJuegoException e) {
			//solo puede pasar en caso de bug.
			e.printStackTrace();
		}
		
		Collection<Terreno> zonaRadioactiva = mapa.obtenerRadioDeCasilleros(1, posicionUnidad);
		Iterator<Terreno> iter = zonaRadioactiva.iterator();
		while(iter.hasNext()){
			afectarZona(iter.next(), 10);
		}
		
	}

	@Override
	public boolean caduco() {
		return unidad.estoyMuerto();
	}
}

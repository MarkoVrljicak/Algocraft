package algocraft.mapa;

import java.util.Iterator;

import algocraft.construccionesAlternativas.Actualizable;
import algocraft.exception.ActualizableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Alternativas.Movible;

public class Desplazador {

	private Mapa mapa;

	public Desplazador(Mapa mapa){
		this.mapa = mapa;
	}

	public boolean moverPorTierra(Movible movible, Coordenada coordenadaDestino) throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException {
		Coordenada coordenadaOrigen = null;
		Terreno terrenoOrigen = null;
		Iterator<Terreno> iterMapa = (Iterator<Terreno>) this.mapa.iterator();
		//si puede moverse a la posicion
		if(!movible.puedoMoverme(this.mapa.getTerreno(coordenadaDestino))){
			return false;
		}
		//encuentra la unidad
		while(iterMapa.hasNext() && coordenadaOrigen == null){
			terrenoOrigen = iterMapa.next();
			Actualizable contenido = terrenoOrigen.getContenidoSuelo();
			if(contenido == movible){
				coordenadaOrigen = terrenoOrigen.getCoordenada();
			}
		}
		
		if(coordenadaOrigen == null){
			throw new ActualizableNoEstaEnJuegoException();//si no encontre
		} else if(coordenadaDestino.distanciaA(coordenadaOrigen) > 1){
			return false;//si me pidieron moverme al mismo lugar
		} else {
			this.mapa.almacenarEnSuelo((Actualizable) movible, coordenadaDestino);
			terrenoOrigen.vaciarSuelo();
			return true;
		}
	}
	
	public boolean moverPorCielo(Movible movible, Coordenada coordenadaDestino) throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException {
		Coordenada coordenadaOrigen = null;
		Terreno terrenoOrigen = null;
		Iterator<Terreno> iterMapa = (Iterator<Terreno>) this.mapa.iterator();
		//si destino es valido
		if(!movible.puedoMoverme(this.mapa.getTerreno(coordenadaDestino))){
			return false;
		}
		//encuentro Unidad e mapa
		while(iterMapa.hasNext() && coordenadaOrigen == null){
			terrenoOrigen = iterMapa.next();
			Actualizable contenido = terrenoOrigen.getContenidoCielo();
			if(contenido == movible){
				coordenadaOrigen = terrenoOrigen.getCoordenada();
			}
		}
		
		if(coordenadaOrigen == null){
			throw new ActualizableNoEstaEnJuegoException();//si no encontre la unidad
		} else if(coordenadaDestino.distanciaA(coordenadaOrigen) > 1){
			return false;//si la mande al mismo lugar
		} else {
			this.mapa.almacenarEnCielo((Actualizable) movible, coordenadaDestino);
			terrenoOrigen.vaciarCielo();
			return true;
		}
	}
	
	
}

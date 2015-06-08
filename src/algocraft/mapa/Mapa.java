package algocraft.mapa;

import java.util.HashMap;
import java.util.Iterator;

import algocraft.creables.Creable;
import algocraft.exception.CreableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Movible;

public class Mapa implements Iterable<Terreno>{

	private HashMap<Coordenada, Terreno> casilleros;
	private int ancho;
	private int alto;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		casilleros = new HashMap<Coordenada, Terreno>();

		for (int i = 1; i <= this.ancho; i++) {
			for (int j = 1; j <= this.alto; j++) {
				setearTerrenoEnCoordenada(Terrenos.TIERRA, i, j);
			}
		}
	}
	
	public void setearTerrenoEnCoordenada(Terrenos terreno, int i, int j){
		Coordenada nuevaCoordenada = new Coordenada(i, j);
		Terreno nuevoTerreno = terreno.crear(i, j);
		casilleros.put(nuevaCoordenada, nuevoTerreno);
	}

	public Terreno obtenerCasillero(Coordenada coordenadaPedida)throws FueraDeLimitesException {
		if (this.hayCasillero(coordenadaPedida))
			return casilleros.get(coordenadaPedida);
		else
			throw new FueraDeLimitesException();
	}

	@Override
	public Iterator<Terreno> iterator() {
		
		return casilleros.values().iterator();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public boolean hayCasillero(Coordenada coordenada) {
		boolean dentroDelAncho=(coordenada.getX()>0 && coordenada.getX()<=this.ancho);
		boolean dentroDelAlto=(coordenada.getY()>0 && coordenada.getY()<=this.alto);
		return (dentroDelAncho && dentroDelAlto);
	}

	public Terrenos obtenerNombreTerreno(Coordenada coordenada) {
		Terreno terreno = null;
		
		try {
			 terreno = obtenerCasillero(coordenada);
		} catch (FueraDeLimitesException e) {
			e.printStackTrace();
		}
		
		return terreno.getNombre();
	}

	public boolean moverPorTierra(Movible movible, Coordenada coordenadaDestino) throws CreableNoEstaEnJuegoException, DestinoInvalidoException {
		Coordenada coordenadaOrigen = null;
		Terreno terrenoOrigen = null;
		Iterator<Terreno> iterMapa = (Iterator<Terreno>) this.iterator();
		
		if(!movible.puedoMoverme(this.getTerreno(coordenadaDestino))){
			return false;
		}

		while(iterMapa.hasNext() && coordenadaOrigen == null){
			terrenoOrigen = iterMapa.next();
			Creable contenido = terrenoOrigen.getContenidoSuelo();
			if(contenido == movible){
				coordenadaOrigen = terrenoOrigen.getCoordenada();
			}
		}
		
		if(coordenadaOrigen == null){
			throw new CreableNoEstaEnJuegoException();
		} else if(coordenadaDestino.distanciaA(coordenadaOrigen) > 1){
			return false;
		} else {
			this.almacenarEnSuelo((Creable) movible, coordenadaDestino);
			terrenoOrigen.vaciarSuelo();
			return true;
		}
	}
	
	public boolean moverPorCielo(Movible movible, Coordenada coordenadaDestino) throws CreableNoEstaEnJuegoException, DestinoInvalidoException {
		Coordenada coordenadaOrigen = null;
		Terreno terrenoOrigen = null;
		Iterator<Terreno> iterMapa = (Iterator<Terreno>) this.iterator();
		
		if(!movible.puedoMoverme(this.getTerreno(coordenadaDestino))){
			return false;
		}

		while(iterMapa.hasNext() && coordenadaOrigen == null){
			terrenoOrigen = iterMapa.next();
			Creable contenido = terrenoOrigen.getContenidoCielo();
			if(contenido == movible){
				coordenadaOrigen = terrenoOrigen.getCoordenada();
			}
		}
		
		if(coordenadaOrigen == null){
			throw new CreableNoEstaEnJuegoException();
		} else if(coordenadaDestino.distanciaA(coordenadaOrigen) > 1){
			return false;
		} else {
			this.almacenarEnCielo((Creable) movible, coordenadaDestino);
			terrenoOrigen.vaciarCielo();
			return true;
		}
	}
	
	public void almacenarEnSuelo(Creable creable, Coordenada coordenada) throws DestinoInvalidoException {
		this.getTerreno(coordenada).almacenarEnSuelo(creable);
	}

	public void almacenarEnCielo(Creable creable, Coordenada coordenada) throws DestinoInvalidoException {
		this.getTerreno(coordenada).almacenarEnCielo(creable);
	}
	
	public Creable getCreableSuelo(Coordenada coordenada) {
		return this.getTerreno(coordenada).getContenidoSuelo();
	}

	public Creable getCreableCielo(Coordenada coordenada) {
		return this.getTerreno(coordenada).getContenidoCielo();
	}
	
	public Terreno getTerreno(Coordenada coordenada){
		return casilleros.get(coordenada);
	}



}

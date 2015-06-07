package algocraft.mapa;

import java.util.HashMap;
import java.util.Iterator;

import algocraft.creables.Creable;
import algocraft.exception.CreableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;

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

	public void almacenarEnSuelo(Creable creable, Coordenada coordenadaDestino) throws DestinoInvalidoException {
		this.getTerreno(coordenadaDestino).almacenarEnSuelo(creable);
	}

	public void moverPorTierra(Creable creable, Coordenada coordenadaDestino) throws CreableNoEstaEnJuegoException, DestinoInvalidoException {
		Coordenada coordenadaOrigen = null;
		Terreno terrenoOrigen = null;
		Iterator<Terreno> iterMapa = (Iterator<Terreno>) this.iterator();
		
		if(this.getCreableSuelo(coordenadaDestino) != null){
			throw new DestinoInvalidoException();
		}

		while(iterMapa.hasNext() && coordenadaOrigen == null){
			terrenoOrigen = iterMapa.next();
			Creable contenido = terrenoOrigen.getContenidoSuelo();
			if(contenido == creable){
				coordenadaOrigen = terrenoOrigen.getCoordenada();
			}
		}
		
		if(coordenadaOrigen == null){
			throw new CreableNoEstaEnJuegoException();
		} else {
			this.almacenarEnSuelo(creable, coordenadaDestino);
			terrenoOrigen.vaciarSuelo();
		}
		
	}

	public Creable getCreableSuelo(Coordenada coordenada) {
		return this.getTerreno(coordenada).getContenidoSuelo();
	}
	
	private Terreno getTerreno(Coordenada coordenada){
		return casilleros.get(coordenada);
	}

}

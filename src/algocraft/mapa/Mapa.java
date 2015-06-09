package algocraft.mapa;

import java.util.HashMap;
import java.util.Iterator;

import algocraft.construccionesAlternativas.Actualizable;
import algocraft.exception.ActualizableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Alternativas.Movible;
import algocraft.unidades.Alternativas.Unidad;

public class Mapa implements Iterable<Terreno>{

	private HashMap<Coordenada, Terreno> casilleros;
	private HashMap<Actualizable, Coordenada> posiciones;
	private int ancho;
	private int alto;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		casilleros = new HashMap<Coordenada, Terreno>();
		posiciones = new HashMap<Actualizable, Coordenada>();

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

	public boolean moverUnidad(Movible movible, Coordenada coordenadaDestino) throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException {
		Unidad unidad = (Unidad) movible;
		
		Coordenada coordenadaOrigen = posiciones.get((Actualizable) movible);
		if(coordenadaOrigen == null){
			throw new ActualizableNoEstaEnJuegoException();
		}
		
		Terreno terrenoOrigen = this.getTerreno(coordenadaOrigen);
		Terreno terrenoDestino = this.getTerreno(coordenadaDestino);
		
		if(!movible.puedoMoverme(terrenoDestino)){
			return false;
		} else if(coordenadaDestino.distanciaA(coordenadaOrigen) > 1){
			return false;
		} else if(!unidad.soyVolador()){
			this.almacenarEnSuelo((Actualizable) movible, coordenadaDestino);
			terrenoOrigen.vaciarSuelo();
		} else if(unidad.soyVolador()){
			this.almacenarEnCielo((Actualizable) movible, coordenadaDestino);
			terrenoOrigen.vaciarCielo();
		}
		
		return true;
	}
	
	public void almacenarEnSuelo(Actualizable actualizable, Coordenada coordenada) throws DestinoInvalidoException {
		posiciones.put(actualizable, coordenada);
		this.getTerreno(coordenada).almacenarEnSuelo(actualizable);
	}

	public void almacenarEnCielo(Actualizable actualizable, Coordenada coordenada) throws DestinoInvalidoException {
		posiciones.put(actualizable, coordenada);
		this.getTerreno(coordenada).almacenarEnCielo(actualizable);
	}
	
	public Actualizable getActualizableSuelo(Coordenada coordenada) {
		return this.getTerreno(coordenada).getContenidoSuelo();
	}

	public Actualizable getActualizableCielo(Coordenada coordenada) {
		return this.getTerreno(coordenada).getContenidoCielo();
	}
	
	public Terreno getTerreno(Coordenada coordenada){
		return casilleros.get(coordenada);
	}

//	public boolean gestionarAtaque(Unidad atacante, Daniable atacado) {
//		Coordenada posicionAtacante = null;
//		Coordenada posicionAtacado = null;
//		SectoresDeTerreno sectorAtacado = null;
//		int distanciaAtaque = 0;
//		
//		Iterator<Terreno> iterMapa = (Iterator<Terreno>) this.iterator();
//		
//		
//		//osea necesito coordenadas
//		atacante.atacar(terrenoDestino, sectorAtacado, distanciaAtaque);
//	}



}

package modelo.mapa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import modelo.exception.CoordenadaInexistenteException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.mapa.terrenos.Aire;
import modelo.mapa.terrenos.Minerales;
import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;
import modelo.mapa.terrenos.Tierra;
import modelo.mapa.terrenos.Volcan;
import modelo.propiedad.Propiedad;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;

public class Mapa implements Iterable<Terreno>{

	private HashMap<Coordenada, Terreno> casilleros;
	private HashMap<Propiedad, Coordenada> posiciones;
	private int ancho;
	private int alto;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		casilleros = new HashMap<Coordenada, Terreno>();
		posiciones = new HashMap<Propiedad, Coordenada>();

		for (int i = 1; i <= this.ancho; i++) {
			for (int j = 1; j <= this.alto; j++) {
				setearTerrenoEnCoordenada(Terrenos.TIERRA, i, j);
			}
		}
	}
	
	//accesors
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public void setearTerrenoEnCoordenada(Terrenos terreno, int i, int j){
		Coordenada nuevaCoordenada = new Coordenada(i, j);
		Terreno nuevoTerreno;
		switch(terreno){
		case AIRE:
			nuevoTerreno = new Aire(nuevaCoordenada);
			break;
		case MINERALES:
			nuevoTerreno = new Minerales(nuevaCoordenada);
			break;
		case TIERRA:
			nuevoTerreno = new Tierra(nuevaCoordenada);
			break;
		case VOLCAN:
			nuevoTerreno = new Volcan(nuevaCoordenada);
			break;
		default:
			nuevoTerreno = new Tierra(nuevaCoordenada);
			break;
		
		}
		casilleros.put(nuevaCoordenada, nuevoTerreno);
	}
	
	public boolean hayCasillero(Coordenada coordenada) {
		boolean dentroDelAncho=(coordenada.getX()>0 && coordenada.getX()<=this.ancho);
		boolean dentroDelAlto=(coordenada.getY()>0 && coordenada.getY()<=this.alto);
		return (dentroDelAncho && dentroDelAlto);
	}

	public Terreno getTerreno(Coordenada coordenadaPedida)throws FueraDeLimitesException {
		if (this.hayCasillero(coordenadaPedida))
			return casilleros.get(coordenadaPedida);
		else
			throw new FueraDeLimitesException();
	}
	

	@Override
	public Iterator<Terreno> iterator() {
		
		return casilleros.values().iterator();
	}
	
	public void almacenar(Propiedad propiedad, Coordenada coordenada)
			throws DestinoInvalidoException, FueraDeLimitesException {
		posiciones.put(propiedad, coordenada);
		this.getTerreno(coordenada).almacenar(propiedad);
	}
	
	public Propiedad getPropiedadSuelo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return this.getTerreno(coordenada).getContenidoSuelo();
	}

	public Propiedad getPropiedadCielo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return this.getTerreno(coordenada).getContenidoCielo();
	}
	
	//movimiento
	
	public void moverUnidad(Unidad unidad, Coordenada destino) throws PropiedadNoEstaEnJuegoException, CoordenadaInexistenteException, PropiedadNoExisteEnEstaUbicacion, DestinoInvalidoException{

		Coordenada origen = posiciones.get(unidad);
		if(origen == null){
			throw new PropiedadNoEstaEnJuegoException();
		}
		
		Collection<Terreno> camino = null;
		camino = this.trazarCamino(origen, destino);
		
		Coordenada coordenadaArribada = unidad.mover(camino);
		
		this.posiciones.put(unidad, coordenadaArribada);
		
	}
	
	public Collection<Terreno> trazarCamino(Coordenada origen, Coordenada destino) throws CoordenadaInexistenteException{
		Collection<Terreno> camino = new ArrayList<Terreno>();
		
		if(this.casilleros.get(origen) == null || this.casilleros.get(destino) == null){
			throw new CoordenadaInexistenteException();
		}
		
		Coordenada coordenadaActual = origen;
		while(coordenadaActual.distanciaA(destino) != 0){
			camino.add(this.casilleros.get(coordenadaActual));
			
			Collection<Terreno> linderos = this.obtenerRadioDeCasilleros(1, coordenadaActual);
			
			Iterator<Terreno> iter = linderos.iterator();
			coordenadaActual = iter.next().getCoordenada();
			
			while(iter.hasNext()){
				int mejorDistancia = coordenadaActual.distanciaA(destino);
				Terreno siguienteTerreno = iter.next();
				Coordenada siguienteCoordenada = siguienteTerreno.getCoordenada();
				if(siguienteCoordenada.distanciaA(destino) < mejorDistancia){
					mejorDistancia = siguienteCoordenada.distanciaA(destino);
					coordenadaActual = siguienteCoordenada;
				}
			}
		}
		camino.add(this.casilleros.get(coordenadaActual));
		
		return camino;
	}
	
	//ataque
	
	public boolean gestionarAtaque(UnidadAtacante atacante, Propiedad atacado) 
			throws PropiedadNoEstaEnJuegoException, FueraDeLimitesException, PropiedadNoExisteEnEstaUbicacion {
		
		Coordenada posicionAtacante = posiciones.get(atacante);
		Coordenada posicionAtacado = posiciones.get(atacado);
		
		if(posicionAtacante == null || posicionAtacado == null){
			throw new PropiedadNoEstaEnJuegoException();
		}
		
		int distanciaAtaque = posicionAtacante.distanciaA(posicionAtacado);
		
		boolean resultado = atacante.atacar(atacado, distanciaAtaque);
		if (atacado.estoyMuerto()){
			limpiarMuerto(atacado);
		}
		
		return resultado;
	}
	
	private void limpiarMuerto(Propiedad propiedad) 
			throws FueraDeLimitesException, PropiedadNoExisteEnEstaUbicacion{
		
		Terreno terreno = this.getTerreno(posiciones.get(propiedad));
		
		terreno.borrarContenido(propiedad);
		
		posiciones.remove(propiedad);
		
	}
	
	public int propiedadesEnJuego(){
		return posiciones.size();
	}
	
	public Coordenada encontrar(Propiedad elementoBuscado){
		return this.posiciones.get(elementoBuscado);
	}
	
	public Collection<Terreno> obtenerRadioDeCasilleros(int radio, Coordenada centro){
		
		Collection<Terreno> outputTerrenos = new ArrayList<Terreno>();
		Iterator<Terreno> iter = this.iterator();
		
		while (iter.hasNext()){
			Terreno terrenoActual = iter.next();
			Coordenada coordenadaActual = terrenoActual.getCoordenada();
			if(coordenadaActual.distanciaA(centro) <= radio){
				outputTerrenos.add(terrenoActual);
			}
		}
		
		return outputTerrenos;
	}

	public Coordenada getPosicionPropiedad(Propiedad propiedad) throws PropiedadNoEstaEnJuegoException {
		if(posiciones.containsKey(propiedad)){
			return posiciones.get(propiedad);
		} else {
			throw new PropiedadNoEstaEnJuegoException();
		}
		
	}

}

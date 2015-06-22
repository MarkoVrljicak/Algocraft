package modelo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import modelo.construcciones.Construccion;
import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EnumEdificios;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.EspacioInsuficienteException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.exception.UnidadIncompletaException;
import modelo.exception.UnidadNoTransportableException;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.mapa.Coordenada;
import modelo.mapa.GeneradorDeMapa;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadTransportadora;
import modelo.unidades.Unidades;

public class Juego extends Observable{
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	public Mapa mapa;
	private ArrayList<CreadorDeUnidades> creadoresDeUnidadesEnUso;
	
	public Juego(int ancho , int alto){
		GeneradorDeMapa generador = new GeneradorDeMapa(ancho, alto);
		mapa = generador.generar();
		creadoresDeUnidadesEnUso = new ArrayList<CreadorDeUnidades>();
	}

	public void setJugador1(String nombre, EnumRazas unaRaza , Colores unColor) {
		this.jugador1 = new Jugador(nombre, unaRaza, unColor);		
	}
	
	public void setJugador2(String nombre, EnumRazas unaRaza , Colores unColor) {
		this.jugador2 = new Jugador(nombre, unaRaza, unColor);		
	}

	public void iniciarJuego() {
		jugadorActual = jugador1 ; 		
	}
	
	public Jugador obtenerJugadorActual() {
		return jugadorActual;
	}
	
	public int getAncho() {
		return mapa.getAncho();
	}
	
	public int getAlto() {
		return mapa.getAlto();
	}
	
	public Terreno obtenerTerreno(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return mapa.getTerreno(coordenada);
	}
	
	public Propiedad seleccionarSuelo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return mapa.getPropiedadSuelo(coordenada);
	}
	
	public Propiedad seleccionarCielo(Coordenada coordenada) 
			throws FueraDeLimitesException {	
		return mapa.getPropiedadCielo(coordenada);
	}

	public void construirEn(EnumEdificios edificio, Coordenada coordenada) 
			throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException,
					GasInsuficienteException, DependenciasNoCumplidasException {
		
		Construccion edificioNuevo = jugadorActual.construir(edificio);
		mapa.almacenar((Propiedad) edificioNuevo, coordenada);
		
		this.notifyObservers();
	}
	
	public void crearUnidad(CreadorDeUnidades edificioCreador, Unidades unidadPedida) 
			throws MineralInsuficienteException,GasInsuficienteException, PoblacionInsuficienteException {
		 jugadorActual.crearUnidad(unidadPedida, edificioCreador);	
		 creadoresDeUnidadesEnUso.add(edificioCreador);
		 
		 this.notifyObservers();
	}

	public void pasarTurno() throws UnidadIncompletaException {
		//cambio de jugador
		if(jugadorActual == jugador1)
			jugadorActual= jugador2;
		else
			jugadorActual = jugador1;
		
		//empiezo su turno
		jugadorActual.iniciarTurno();
		
		//gestiono creacion de unidades
		ponerNuevasUnidadesEnMapa();
		
		this.notifyObservers();
	}

	private void ponerNuevasUnidadesEnMapa() throws UnidadIncompletaException {
		Iterator<CreadorDeUnidades> itEdificiosCreadores = creadoresDeUnidadesEnUso.iterator();
		while(itEdificiosCreadores.hasNext()){
			CreadorDeUnidades unCreador = itEdificiosCreadores.next();
			if(unCreador.getDuenio()==jugadorActual && unCreador.unidadEnCreacion() && unCreador.unidadTerminada()){
				Unidad  unidadTerminada = unCreador.obtenerUnidadCreada();
				this.posicionarNuevaUnidad(unidadTerminada,this.mapa.encontrar(unCreador));		
				//si no pudo lo intenta de nuevo en el proximo turno
			}
			if(!unCreador.unidadEnCreacion()){
				creadoresDeUnidadesEnUso.remove(unCreador);	
				itEdificiosCreadores = creadoresDeUnidadesEnUso.iterator();
			}
		}
	}

	private void posicionarNuevaUnidad(Unidad unidad, Coordenada posicionCreador){
		for(int x = posicionCreador.getX()-1 ; x <= posicionCreador.getX()+1 ; x++){
			for(int y = posicionCreador.getY()-1 ; y <= posicionCreador.getY()+1 ; y++){
				Coordenada coordenadaCandidata = new Coordenada(x,y);
				try {
					if(this.mapa.hayCasillero(coordenadaCandidata) &&
							unidad.puedoMoverme(this.mapa.getTerreno(coordenadaCandidata))){
						this.mapa.almacenar(unidad,coordenadaCandidata );
					}
				} catch (FueraDeLimitesException | DestinoInvalidoException e) {
					//no ocurren(pregunto si hay casillero y si puedo estar ahi)
					e.printStackTrace();
				}
			}
		}
		
		this.notifyObservers();
	}

	public void moverUnidad(Unidad unidad, Coordenada destino) 
			throws PropiedadNoEstaEnJuegoException {
		this.mapa.moverUnidad(unidad, destino);	
		
		this.notifyObservers();
	}

	public void subirUnidad(Unidad unidadSubida, UnidadTransportadora naveTransportadora) 
			throws EspacioInsuficienteException, UnidadNoTransportableException {
		naveTransportadora.subirUnidad(unidadSubida);
		try {
			mapa.getTerreno(mapa.encontrar(unidadSubida)).borrarContenido(unidadSubida);
		} catch (PropiedadNoExisteEnEstaUbicacion | FueraDeLimitesException e) {
			// contradiccion
			e.printStackTrace();
		}
		
		this.notifyObservers();
	}

	public void bajarUnidad(UnidadTransportadora naveTransportadora, Unidad unidadABajar)
			throws DestinoInvalidoException {
		Coordenada posicionDescenso = mapa.encontrar(naveTransportadora);
		Unidad unidadBajada = naveTransportadora.bajarUnidad(unidadABajar);
		try {
			mapa.almacenar(unidadBajada, posicionDescenso);
		} catch (FueraDeLimitesException e) {
			// contradiccion
			e.printStackTrace();
		}
		
		this.notifyObservers();
	}	
}

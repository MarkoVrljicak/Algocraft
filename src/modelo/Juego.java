package modelo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import modelo.construcciones.Construccion;
import modelo.construcciones.CreadorDeUnidades;
import modelo.construcciones.EnumEdificios;
import modelo.exception.ColorRepetidoExepcion;
import modelo.exception.CoordenadaInexistenteException;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.EspacioInsuficienteException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.MinimoCuatroCaracteresException;
import modelo.exception.NombreRepetidoExepcion;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.exception.RecursosNegativosException;
import modelo.exception.UnidadIncompletaException;
import modelo.exception.UnidadNoTransportableException;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.mapa.Coordenada;
import modelo.mapa.GeneradorDeMapa;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.propiedad.Propiedad;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;
import modelo.unidades.UnidadTransportadora;
import modelo.unidades.Unidades;

public class Juego extends Observable{

	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	public Mapa mapa;
	private ArrayList<CreadorDeUnidades> creadoresDeUnidadesEnUso;
	private Coordenada base1;
	private Coordenada base2;

	public Juego(int ancho , int alto) throws FueraDeLimitesException{
		GeneradorDeMapa generador = new GeneradorDeMapa(ancho, alto);
		mapa = generador.generar();
		base1 = generador.getPosicionBase1();
		base2 = generador.getPosicionBase2();
		creadoresDeUnidadesEnUso = new ArrayList<CreadorDeUnidades>();
	}

	public void setJugador1(String nombre, EnumRazas unaRaza , Colores unColor) throws MinimoCuatroCaracteresException {
		this.validacionNombreJugador(nombre);
		this.jugador1 = new Jugador(nombre, unaRaza, unColor);		
	}

	public void setJugador2(String nombre, EnumRazas unaRaza , Colores unColor) 
			throws MinimoCuatroCaracteresException, NombreRepetidoExepcion, ColorRepetidoExepcion {
		this.validacionNombreJugador(nombre);
		this.validacionJugadorDos(nombre, unColor);
		this.jugador2 = new Jugador(nombre, unaRaza, unColor);		
	}

	private void validacionNombreJugador(String nombre) throws MinimoCuatroCaracteresException{
		if (nombre.length() < 4) throw new MinimoCuatroCaracteresException();
	}

	private void validacionJugadorDos(String nombre, Colores unColor) throws NombreRepetidoExepcion, ColorRepetidoExepcion{
		if (nombre == jugador1.getNombre()) throw new NombreRepetidoExepcion();
		if (unColor == jugador1.getColor()) throw new ColorRepetidoExepcion();
	}

	public void iniciarJuego() throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException {
		posicionarBases();

		jugadorActual = jugador1 ;

		this.setChanged();
		this.notifyObservers();
	}

	private void posicionarBases() throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException {

		jugadorActual = jugador1 ;
		switch(jugadorActual.getRaza()){
		case PROTOSS:
			construirEn(EnumEdificiosProtos.BASE_PROTOSS,base1);
			break;
		case TERRAN:
			construirEn(EnumEdificiosTerran.BASE_TERRAN,base1);
			break;			
		}

		jugadorActual = jugador2 ;
		switch(jugadorActual.getRaza()){
		case PROTOSS:
			construirEn(EnumEdificiosProtos.BASE_PROTOSS,base2);
			break;
		case TERRAN:
			construirEn(EnumEdificiosTerran.BASE_TERRAN,base2);
			break;			
		}



	}

	public Jugador getJugadorActual() {
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
			GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException {

		Construccion edificioNuevo = jugadorActual.construir(edificio);
		mapa.almacenar((Propiedad) edificioNuevo, coordenada);

		this.setChanged();
		this.notifyObservers();
	}

	public void crearUnidad(CreadorDeUnidades edificioCreador, Unidades unidadPedida) 
			throws MineralInsuficienteException,GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException {

		jugadorActual.crearUnidad(unidadPedida, edificioCreador);	
		creadoresDeUnidadesEnUso.add(edificioCreador);

		this.setChanged();
		this.notifyObservers();
	}

	public void pasarTurno() 
			throws UnidadIncompletaException, DestinoInvalidoException, 
			FueraDeLimitesException, PropiedadNoEstaEnJuegoException {
		
		if(jugadorActual == jugador1)
			jugadorActual= jugador2;
		else if(jugadorActual == jugador2)
			jugadorActual= jugador1;

		
		jugadorActual.iniciarTurno();

		
		ponerNuevasUnidadesEnMapa();

		this.setChanged();
		this.notifyObservers();
	}

	private void ponerNuevasUnidadesEnMapa() throws UnidadIncompletaException, DestinoInvalidoException, FueraDeLimitesException {
		
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

	private void posicionarNuevaUnidad(Unidad unidad, Coordenada posicionCreador) throws DestinoInvalidoException, FueraDeLimitesException{
		boolean posicionado = false;
		for(int x = posicionCreador.getX()-1 ; x <= posicionCreador.getX()+1 && !posicionado; x++){
			for(int y = posicionCreador.getY()-1 ; y <= posicionCreador.getY()+1 && !posicionado; y++){
				Coordenada coordenadaCandidata = new Coordenada(x,y);
				if(this.mapa.hayCasillero(coordenadaCandidata) &&
						unidad.puedoMoverme(this.mapa.getTerreno(coordenadaCandidata))){
					this.mapa.almacenar(unidad,coordenadaCandidata );
					posicionado = true;					
				}
			}	
		}
	}

	public void moverUnidad(Unidad unidad, Coordenada destino) 
			throws PropiedadNoEstaEnJuegoException, CoordenadaInexistenteException, PropiedadNoExisteEnEstaUbicacion, DestinoInvalidoException {
		this.mapa.moverUnidad(unidad, destino);	

		this.setChanged();
		this.notifyObservers();
	}

	public void subirUnidad(Unidad unidadSubida, UnidadTransportadora naveTransportadora) 
			throws EspacioInsuficienteException, UnidadNoTransportableException, PropiedadNoExisteEnEstaUbicacion, FueraDeLimitesException {
		
		if(mapa.encontrar(unidadSubida).distanciaA(mapa.encontrar(naveTransportadora))<=1){
			naveTransportadora.subirUnidad(unidadSubida);
			mapa.getTerreno(mapa.encontrar(unidadSubida)).borrarContenido(unidadSubida);
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void bajarUnidad(UnidadTransportadora naveTransportadora, Unidad unidadABajar)
			throws DestinoInvalidoException, FueraDeLimitesException {
		
		Coordenada posicionDescenso = mapa.encontrar(naveTransportadora);
		if(mapa.getTerreno(posicionDescenso).sePuedeCaminar()){
			Unidad unidadBajada = naveTransportadora.bajarUnidad(unidadABajar);		
			mapa.almacenar(unidadBajada, posicionDescenso);
		} else{
			throw new DestinoInvalidoException();
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void realizarAtaque(UnidadAtacante atacante, Coordenada posicionAtacado) throws FueraDeLimitesException {
		Propiedad atacado = mapa.getTerreno(posicionAtacado).getContenidoSuelo();

		try {
			mapa.gestionarAtaque(atacante, atacado);
		} catch (PropiedadNoEstaEnJuegoException
				| PropiedadNoExisteEnEstaUbicacion e) {
			//no se lanza
			e.printStackTrace();
		}

		this.setChanged();
		this.notifyObservers();
	}

	public boolean hayGanador(){
		if(jugador1Perdio()&&jugador2Perdio())
			return false;		
		if(jugador1Perdio() && !jugador2Perdio())
			return true;
		else if(jugador2Perdio() && !jugador1Perdio())
			return true;
		else
			return false;

	}

	public String getNombreGanador(){
		if((jugador1Perdio() && jugador2Perdio())|| (!jugador1Perdio() && !jugador2Perdio())){
			return "No Hay Ganador";
		}else if(jugador1Perdio()){
			return jugador2.getNombre();
		}else if(jugador2Perdio()){
			return jugador1.getNombre();
		}else
			return "No Hay Ganador";
	}

	private boolean jugador1Perdio() {
		return (jugador1.cantidadConstrucciones() == 0 && jugador1.getPoblacionActual() == 0);
	}

	private boolean jugador2Perdio() {
		return (jugador2.cantidadConstrucciones() == 0 && jugador2.getPoblacionActual() == 0);
	}


}

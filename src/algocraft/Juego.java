package algocraft;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import algocraft.Interfaces.Actualizable;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.construcciones.EnumEdificios;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.mapa.Coordenada;
import algocraft.mapa.GeneradorDeMapa;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.propiedad.Propiedad;
import algocraft.razas.Raza;
import algocraft.unidades.Unidad;
import algocraft.unidades.Unidades;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	public Mapa mapa;
	private HashMap<CreadorDeUnidades,Queue<Unidad>> unidadesEnCreacion;
	
	public Juego(int ancho , int alto){
		GeneradorDeMapa generador = new GeneradorDeMapa(ancho, alto);
		mapa = generador.generar();
		unidadesEnCreacion = new HashMap<CreadorDeUnidades, Queue<Unidad>>();
	}

	public void setJugador1(String nombre, Raza unaRaza , Colores unColor) {
		this.jugador1 = new Jugador(nombre, unaRaza, unColor);		
	}
	
	public void setJugador2(String nombre, Raza unaRaza , Colores unColor) {
		this.jugador2 = new Jugador(nombre, unaRaza, unColor);		
	}

	public void iniciarJuego() {
		jugadorActual = jugador1 ; 		
	}
	
	public Jugador obtenerJugadorActual() {
		return jugadorActual;
	}
	
	public Terreno obtenerTerreno(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return mapa.getTerreno(coordenada);
	}
	
	public Actualizable seleccionarSuelo(Coordenada coordenada) 
			throws FueraDeLimitesException {
		return mapa.getPropiedadSuelo(coordenada);
	}

	public void construirEn(EnumEdificios edificio, Coordenada coordenada) 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Construccion edificioNuevo = jugadorActual.construir(edificio);
		mapa.almacenar((Propiedad) edificioNuevo, coordenada);
	}

	public void pasarTurno() {
		//cambio de jugador
		if(jugadorActual == jugador1)
			jugadorActual= jugador2;
		else
			jugadorActual = jugador1;
		
		//empiezo su turno
		jugadorActual.iniciarTurno();
		
		//gestiono creacion de unidades
		Iterator<CreadorDeUnidades> itEdificiosCreadores = unidadesEnCreacion.keySet().iterator();
		while(itEdificiosCreadores.hasNext()){
			CreadorDeUnidades unCreador = itEdificiosCreadores.next();
			if(unCreador.getDuenio()==jugadorActual){
				Unidad primerUnidadEnLista = unidadesEnCreacion.get(unCreador).element();
				if(primerUnidadEnLista.enConstruccion())
					primerUnidadEnLista.disminuirTiempoDeConstruccion();
				else
					this.posicionarNuevaUnidad(unidadesEnCreacion.get(unCreador).poll(),
							this.mapa.encontrar(unCreador));
				//si no pudo lo intenta de nuevo en el proximo turno
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
	}

	public void crearUnidad(CreadorDeUnidades edificioCreador, Unidades unidadPedida) {
		 Unidad nuevaUnidad = jugadorActual.crearUnidad(unidadPedida, edificioCreador);	
		 if(!unidadesEnCreacion.containsKey(edificioCreador))
			unidadesEnCreacion.put(edificioCreador, new LinkedList<Unidad>());		 
		 unidadesEnCreacion.get(edificioCreador).add(nuevaUnidad);
	}
}

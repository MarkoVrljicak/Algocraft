package modelo;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import modelo.construcciones.Construccion;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.CoordenadaInexistenteException;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.EspacioInsuficienteException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
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
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadTransportadora;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class JuegoTest {
	
	private int ancho = 30;
	private int alto = 30;

	private Juego iniciarJuegoConDosJugadores() throws FueraDeLimitesException{
		Juego algocraft = new Juego(ancho,alto);
		algocraft.setJugador1("Agustin", EnumRazas.TERRAN , Colores.AZUL );
		algocraft.setJugador2("Marco", EnumRazas.PROTOSS , Colores.ROJO );
		algocraft.iniciarJuego();
		
		return algocraft;
	}
	
	private Coordenada encontrarTerrenoVacio(Terrenos terrenoBuscado,Juego algocraft) 
			throws FueraDeLimitesException{
		for(int i = 1 ; i<=ancho ; i++){
			for(int j = 1 ; j<=alto ; j++){
				Coordenada unaPosicion = new Coordenada(i,j);
				Terreno unTerreno = algocraft.obtenerTerreno(unaPosicion);
				if( (unTerreno.getNombre() == terrenoBuscado) && (unTerreno.getContenidoSuelo() == null) )
					return unaPosicion;
			}
		}
		return null; //no se encontro en todo el mapa
	}
	
	private void juntarRecursosParaAmbosJugadores(Juego algocraft) 
			throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException,
					GasInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, PropiedadNoEstaEnJuegoException, RecursosNegativosException{
		final int muchosTurnos = 400; 
		
		algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosTerran.REFINERIA,
				this.encontrarTerrenoVacio(Terrenos.VOLCAN, algocraft));
		
		algocraft.pasarTurno();
		
		algocraft.construirEn(EnumEdificiosProtos.NEXO_MINERAL,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosProtos.NEXO_MINERAL,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosProtos.ASIMILADOR,
				this.encontrarTerrenoVacio(Terrenos.VOLCAN, algocraft));
		
		for (int turnos=0; turnos<=muchosTurnos ; turnos++){
			algocraft.pasarTurno();
		}
		//nota: al salir es el turno del jugador 1
	}

	private CreadorDeUnidades crearBarracaListaEn(Juego algocraft, Coordenada posicion) 
			throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException,
					GasInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, RecursosNegativosException, PropiedadNoEstaEnJuegoException{
		
		algocraft.construirEn(EnumEdificiosTerran.BARRACA, posicion);
		CreadorDeUnidades barraca=(CreadorDeUnidades) algocraft.seleccionarSuelo(posicion);
		while(barraca.enConstruccion()){
			algocraft.pasarTurno();
		}
		return barraca;
	}
	
	private CreadorDeUnidades crearFabricaListaEn(Juego algocraft,Coordenada posicion) 
			throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException,
					GasInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, RecursosNegativosException, PropiedadNoEstaEnJuegoException {
		
		algocraft.construirEn(EnumEdificiosTerran.FABRICA, posicion);
		CreadorDeUnidades fabrica=(CreadorDeUnidades) algocraft.seleccionarSuelo(posicion);
		while(fabrica.enConstruccion()){
			algocraft.pasarTurno();
		}
		return fabrica;
	}
	
	private CreadorDeUnidades crearPuertoListoEn(Juego algocraft,Coordenada posicion) 
			throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException, 
					GasInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, RecursosNegativosException, PropiedadNoEstaEnJuegoException {
		
		algocraft.construirEn(EnumEdificiosTerran.PUERTO_ESTELAR, posicion);
		CreadorDeUnidades puerto=(CreadorDeUnidades) algocraft.seleccionarSuelo(posicion);
		while(puerto.enConstruccion()){
			algocraft.pasarTurno();
		}
		return puerto;
	}
	
	@Test
	public void testCreoEdificioEnPosicionVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException,
			MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , new Coordenada(6,alto-4));
		
		Construccion edificioConstruido =  (Construccion) algocraft.seleccionarSuelo(new Coordenada(6,26));
		assertEquals(EnumEdificiosTerran.BARRACA , edificioConstruido.getNombre() );
	}
	
	
	@Test(expected = DestinoInvalidoException.class)
	public void testIntentarCrearEdificioEnAireLanzaDestinoInvalido() 
			throws DestinoInvalidoException, FueraDeLimitesException, 
			MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada posicionInvalida = this.encontrarTerrenoVacio(Terrenos.AIRE, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , posicionInvalida);
	}
	
	@Test(expected = DestinoInvalidoException.class)
	public void testIntentarCrearEdificioIncorrectoEnMineralLanzaDestinoInvalido() 
			throws DestinoInvalidoException, FueraDeLimitesException, 
			MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada posicionInvalida = this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , posicionInvalida);
	}
	
	
	@Test
	public void testCreoCentroMineralEnCristalesVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException, 
			MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada unaPosicion = this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES , unaPosicion);
		Construccion edificioConstruido = (Construccion) algocraft.seleccionarSuelo(unaPosicion);
		
		assertEquals(EnumEdificiosTerran.CENTRO_DE_MINERALES , edificioConstruido.getNombre() );
	}
	
	
	@Test
	public void testCreoRefineriaEnVolcanVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException, 
			MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada unaPosicion = this.encontrarTerrenoVacio(Terrenos.VOLCAN, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.REFINERIA , unaPosicion);
		Construccion edificioConstruido = (Construccion) algocraft.seleccionarSuelo(unaPosicion);
		
		assertEquals(EnumEdificiosTerran.REFINERIA , edificioConstruido.getNombre() );
	}
	
	
	@Test
	public void testPasarTurnoCambiaElJugadorActual() throws UnidadIncompletaException, DestinoInvalidoException, FueraDeLimitesException, PropiedadNoEstaEnJuegoException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		
		algocraft.pasarTurno();
		
		assertEquals(Colores.ROJO,algocraft.getJugadorActual().getColor());
	}
	
	@Test
	public void testCreoUnidadEsperoQueSeConstruyaVerificoQueEsteAlLadoDeSuBarraca() 
			throws DestinoInvalidoException, FueraDeLimitesException,
				MineralInsuficienteException, GasInsuficienteException, 
				PoblacionInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, RecursosNegativosException, PropiedadNoEstaEnJuegoException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		this.juntarRecursosParaAmbosJugadores(algocraft);
		Coordenada posicionBarraca = new Coordenada(6,alto-5);
		algocraft.construirEn(EnumEdificiosTerran.BARRACA, posicionBarraca);
		CreadorDeUnidades barraca=(CreadorDeUnidades) algocraft.seleccionarSuelo(posicionBarraca);
		while(barraca.enConstruccion()){
			algocraft.pasarTurno();
		}
		
		algocraft.crearUnidad(barraca, UnidadesTerran.MARINE);
		for(int turnos=1 ; turnos<=8 ; turnos++)
			algocraft.pasarTurno();
		
		Coordenada posicionMarine = encontrarUnidad(algocraft,	UnidadesTerran.MARINE);
		assertTrue(posicionBarraca.distanciaA(posicionMarine) == 1);
	}

	private Coordenada encontrarUnidad(Juego algocraft, UnidadesTerran nombreUnidad) {
		boolean encontrado = false;
		for(int x = 1 ; x <= ancho  && !encontrado; x++){
			for(int y = 1 ; y <= alto && !encontrado; y++){
				Coordenada coordenadaCandidata = new Coordenada(x,y);
				try{
					Unidad unidadEncontrada = (Unidad)algocraft.seleccionarSuelo(coordenadaCandidata);
					if(!(unidadEncontrada==null) && unidadEncontrada.getNombre()==nombreUnidad){
						encontrado = true;
						return coordenadaCandidata;
					}
					unidadEncontrada = (Unidad)algocraft.seleccionarCielo(coordenadaCandidata);
					if(!(unidadEncontrada==null) && unidadEncontrada.getNombre()==nombreUnidad){
						encontrado = true;
						return coordenadaCandidata;
					}
				}catch(ClassCastException | FueraDeLimitesException e){
					//se que esto no se debe hacer pero no se de que otra forma
					//probarlo sin generar metodos especificos en el modelo para el test
				}
			}
		}
		return null;
	}

	@Test
	public void testTransportoMarineATravesDeAire() 
			throws DestinoInvalidoException, FueraDeLimitesException,PropiedadNoEstaEnJuegoException,
					EspacioInsuficienteException, UnidadNoTransportableException,MineralInsuficienteException,
					GasInsuficienteException, PoblacionInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, RecursosNegativosException, PropiedadNoExisteEnEstaUbicacion, CoordenadaInexistenteException{
		
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		inyectarMapaEspecial(algocraft);
		this.juntarRecursosParaAmbosJugadores(algocraft);
		Coordenada posicionBarraca = new Coordenada(5,3);
		CreadorDeUnidades barraca = this.crearBarracaListaEn(algocraft, posicionBarraca);
		Coordenada posicionFabrica = new Coordenada(6,3);
		this.crearFabricaListaEn(algocraft, posicionFabrica);
		Coordenada posicionPuerto = new Coordenada(4,3);
		CreadorDeUnidades puerto = this.crearPuertoListoEn(algocraft, posicionPuerto);
		
		algocraft.crearUnidad(barraca, UnidadesTerran.MARINE);
		algocraft.crearUnidad(puerto, UnidadesTerran.NAVE_TRANSPORTE);
		while(puerto.unidadEnCreacion()){
			algocraft.pasarTurno();
		}
		algocraft.pasarTurno();
		Coordenada posicionMarine = encontrarUnidad(algocraft,UnidadesTerran.MARINE);
		UnidadTransportadora nave = (UnidadTransportadora) algocraft.seleccionarCielo(
				encontrarUnidad(algocraft,UnidadesTerran.NAVE_TRANSPORTE));
		
		algocraft.moverUnidad(nave,posicionMarine);
		
		algocraft.subirUnidad((Unidad) algocraft.seleccionarSuelo(posicionMarine),nave);
		
		assertEquals(null,algocraft.seleccionarSuelo(posicionMarine));

		//paso un turno y vuelvo a mi turno para que tenga movimientos suficientes
		algocraft.pasarTurno();
		algocraft.pasarTurno();
		
		Coordenada destino = new Coordenada(5,6);
		
		algocraft.moverUnidad(nave, destino);
		algocraft.bajarUnidad(nave,nave.obtenerTranspotados().get(0));
		
		 assertEquals(UnidadesTerran.MARINE, ((Unidad)algocraft.seleccionarSuelo(algocraft.mapa.encontrar(nave))).getNombre());
		
		this.ancho = 30;
		this.alto = 30;
	}

	private void inyectarMapaEspecial(Juego algocraft) {
		this.ancho = 10;
		this.alto = 10;
		Mapa mapaEspecial = new Mapa(ancho,alto);
		for(int i = 1 ; i <= 10 ; i++){
			mapaEspecial.setearTerrenoEnCoordenada(Terrenos.MINERALES, i, 1);
			mapaEspecial.setearTerrenoEnCoordenada(Terrenos.MINERALES, i, 10);
			mapaEspecial.setearTerrenoEnCoordenada(Terrenos.VOLCAN, i, 2);
			mapaEspecial.setearTerrenoEnCoordenada(Terrenos.VOLCAN, i, 9);
			mapaEspecial.setearTerrenoEnCoordenada(Terrenos.AIRE, i, 5);
		}
		algocraft.mapa = mapaEspecial;
		
	}
	
	@Test
	public void testJuegadoresEmpiezanConBases() 
			throws FueraDeLimitesException, UnidadIncompletaException, DestinoInvalidoException, PropiedadNoEstaEnJuegoException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Jugador jugador1 = algocraft.getJugadorActual();
		
		assertTrue(jugador1.tieneConstruccion(EnumEdificiosTerran.BASE_TERRAN));
		
		algocraft.pasarTurno();
		Jugador jugador2 = algocraft.getJugadorActual();
		
		assertTrue(jugador2.tieneConstruccion(EnumEdificiosProtos.BASE_PROTOSS));
	}
}

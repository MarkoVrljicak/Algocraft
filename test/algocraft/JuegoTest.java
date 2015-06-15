package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.mapa.Coordenada;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.razas.Protoss;
import algocraft.razas.Terran;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

public class JuegoTest {
	
	private static final int ancho = 30;
	private static final int alto = 30;

	public Juego iniciarJuegoConDosJugadores(){
		Juego algocraft = new Juego(ancho,alto);
		algocraft.setJugador1("Agustin", new Terran() , Colores.AZUL );
		algocraft.setJugador2("Marco", new Protoss() , Colores.ROJO );
		algocraft.iniciarJuego();
		
		return algocraft;
	}
	
	public Coordenada encontrarTerrenoVacio(Terrenos terrenoBuscado,Juego algocraft) 
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
			throws DestinoInvalidoException, FueraDeLimitesException {
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
	
	@Test
	public void testCreoEdificioEnPosicionVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , new Coordenada(6,26));
		
		Construccion edificioConstruido =  (Construccion) algocraft.seleccionarSuelo(new Coordenada(6,26));
		assertEquals(EnumEdificiosTerran.BARRACA , edificioConstruido.getNombre() );
	}
	
	
	@Test(expected = DestinoInvalidoException.class)
	public void testIntentarCrearEdificioEnAireLanzaDestinoInvalido() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada posicionInvalida = this.encontrarTerrenoVacio(Terrenos.AIRE, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , posicionInvalida);
	}
	
	@Test(expected = DestinoInvalidoException.class)
	public void testIntentarCrearEdificioIncorrectoEnMineralLanzaDestinoInvalido() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada posicionInvalida = this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , posicionInvalida);
	}
	
	
	@Test
	public void testCreoCentroMineralEnCristalesVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada unaPosicion = this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES , unaPosicion);
		Construccion edificioConstruido = (Construccion) algocraft.seleccionarSuelo(unaPosicion);
		
		assertEquals(EnumEdificiosTerran.CENTRO_DE_MINERALES , edificioConstruido.getNombre() );
	}
	
	
	@Test
	public void testCreoRefineriaEnVolcanVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		Coordenada unaPosicion = this.encontrarTerrenoVacio(Terrenos.VOLCAN, algocraft);
		
		algocraft.construirEn(EnumEdificiosTerran.REFINERIA , unaPosicion);
		Construccion edificioConstruido = (Construccion) algocraft.seleccionarSuelo(unaPosicion);
		
		assertEquals(EnumEdificiosTerran.REFINERIA , edificioConstruido.getNombre() );
	}
	
	
	@Test
	public void testPasarTurnoCambiaElJugadorActual(){
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		
		algocraft.pasarTurno();
		
		assertEquals(Colores.ROJO,algocraft.obtenerJugadorActual().getColor());
	}
	
	@Test
	public void testCreoUnidadEsperoQueSeConstruyaVerificoQueEsteAlLadoDeSuBarraca() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = this.iniciarJuegoConDosJugadores();
		this.juntarRecursosParaAmbosJugadores(algocraft);
		//creo barraca
		Coordenada posicionBarraca = new Coordenada(6,alto-5);
		algocraft.construirEn(EnumEdificiosTerran.BARRACA, posicionBarraca);
		//espero a que se construya
		CreadorDeUnidades barraca=(CreadorDeUnidades) algocraft.seleccionarSuelo(posicionBarraca);
		while(barraca.enConstruccion()){
			algocraft.pasarTurno();
		}
		
		//creo marine
		algocraft.crearUnidad(barraca, UnidadesTerran.MARINE);
		for(int turnos=1 ; turnos<=8 ; turnos++)
			algocraft.pasarTurno();
		
		//lo busco donde corresponde
		boolean encontrado = false;
		for(int x = posicionBarraca.getX()-1 ; x <= posicionBarraca.getX()+1  && !encontrado; x++){
			for(int y = posicionBarraca.getY()-1 ; y <= posicionBarraca.getY()+1 && !encontrado; y++){
				Coordenada coordenadaCandidata = new Coordenada(x,y);
				if(algocraft.seleccionarSuelo(coordenadaCandidata) != null)
					try{
						Unidad unidadEncontrada = (Unidad)algocraft.seleccionarSuelo(coordenadaCandidata);
						if(unidadEncontrada.getNombre()==UnidadesTerran.MARINE) encontrado = true;
					}catch(ClassCastException e){
						e.printStackTrace();
					}
			}
		}
		assertTrue(encontrado);
	}

	
}

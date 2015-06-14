package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.mapa.Coordenada;
import algocraft.mapa.terrenos.Terreno;
import algocraft.razas.Protoss;
import algocraft.razas.Terran;

public class JuegoTest {

	@Test
	public void testCreoEdificioEnPosicionVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = new Juego(30,30);
		algocraft.setJugador1("Agustin", new Terran() , Colores.AZUL );
		algocraft.setJugador2("Marco", new Protoss() , Colores.ROJO );
		algocraft.iniciarJuego();
		
		algocraft.construirEn(EnumEdificiosTerran.BARRACA , new Coordenada(6,26));
		
		Construccion edificioConstruido =  (Construccion) algocraft.seleccionarSuelo(new Coordenada(6,26));
		assertEquals(EnumEdificiosTerran.BARRACA , edificioConstruido.getNombre() );
	}
	
	@Test(expected = DestinoInvalidoException.class)
	public void testIntentarCrearEdificioEnAireLanzaDestinoInvalido() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = new Juego(20,20);
		algocraft.setJugador1("Agustin", new Terran() , Colores.AZUL );
		algocraft.setJugador2("Marco", new Protoss() , Colores.ROJO );
		algocraft.iniciarJuego();
		
		//busco un aire
		for(int i = 1 ; i<=20  ; i++){
			for(int j = 1 ; j<=20 ; j++){
				Coordenada unaPosicion = new Coordenada(i,j);
				Terreno unTerreno = algocraft.obtenerTerreno(unaPosicion);
				if(! unTerreno.sePuedeEdificar()){
					algocraft.construirEn(EnumEdificiosTerran.BARRACA , unaPosicion);//tira error y sale solo
				}
			}
		}
	}
	
	@Test
	public void testCreoCentroMineralEnCristalesVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = new Juego(30,30);
		algocraft.setJugador1("Agustin", new Terran() , Colores.AZUL );
		algocraft.setJugador2("Marco", new Protoss() , Colores.ROJO );
		algocraft.iniciarJuego();
		
		//busco un cristal y construyo sobre el
		Construccion edificioConstruido = null;
		boolean cristalEncontrado = false;
		for(int i = 1 ; i<=30 && !cristalEncontrado ; i++){
			for(int j = 1 ; j<=30 && !cristalEncontrado ; j++){
				Coordenada unaPosicion = new Coordenada(i,j);
				Terreno unTerreno = algocraft.obtenerTerreno(unaPosicion);
				if(unTerreno.sePuedeMinar()){
					algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES , unaPosicion);
					edificioConstruido = (Construccion) algocraft.seleccionarSuelo(unaPosicion);
					cristalEncontrado = true;
				}
			}
		}
		assertEquals(EnumEdificiosTerran.CENTRO_DE_MINERALES , edificioConstruido.getNombre() );
	}
	
	@Test
	public void testCreoRefineriaEnVolcanVerificoQueEsteAhi() 
			throws DestinoInvalidoException, FueraDeLimitesException{
		Juego algocraft = new Juego(30,30);
		algocraft.setJugador1("Agustin", new Terran() , Colores.AZUL );
		algocraft.setJugador2("Marco", new Protoss() , Colores.ROJO );
		algocraft.iniciarJuego();
		
		//busco un volcan y construyo sobre el
		Construccion edificioConstruido = null;
		boolean volcanEncontrado = false;
		for(int i = 1 ; i<=30 && !volcanEncontrado ; i++){
			for(int j = 1 ; j<=30 && !volcanEncontrado ; j++){
				Coordenada unaPosicion = new Coordenada(i,j);
				Terreno unTerreno = algocraft.obtenerTerreno(unaPosicion);
				if(unTerreno.tieneGas()){
					algocraft.construirEn(EnumEdificiosTerran.REFINERIA , unaPosicion);
					edificioConstruido = (Construccion) algocraft.seleccionarSuelo(unaPosicion);
					volcanEncontrado = true;
				}
			}
		}
		
		assertEquals(EnumEdificiosTerran.REFINERIA , edificioConstruido.getNombre() );
	}
	
	
}

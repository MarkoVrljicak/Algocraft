package modelo.ataques;

import static org.junit.Assert.assertEquals;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.mapa.Mapa;
import modelo.mapa.terrenos.SectoresDeTerreno;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadAtacante;
import modelo.unidades.protos.Dragon;
import modelo.unidades.protos.Zealot;
import modelo.unidades.terran.Espectro;
import modelo.unidades.terran.Marine;
import modelo.unidades.terran.NaveCiencia;

import org.junit.Test;

public class AtaqueNormalTest {
	Coordenada coordenadaAtacante = new Coordenada(1,1);
	Coordenada coordenadaEnRango = new Coordenada(2,2);
	Coordenada coordenadaFueraDeRango = new Coordenada(10,10);
	
	int vidaMaximaMarine = 40;
	int vidaMaximaNave = 200;
	int danioMarine = 6;
	
	SectoresDeTerreno suelo = SectoresDeTerreno.SUELO;
	SectoresDeTerreno cielo = SectoresDeTerreno.CIELO;
	
	@Test
	public void testAtaqueNormalTerrestreSeRealiza() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		
		//Puedo hacer esto porque se donde puse a los marines.
		//En realidad es Mapa quien tiene que suministrarle
		//la informacion al metodo atacar.
		
		assertEquals(true, marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}
	
	@Test
	public void testUnidadTerrestreRecibeDanioDeAtaqueNormal() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		
		marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango));
		
		assertEquals(vidaMaximaMarine - danioMarine, marineAtacado.getVida());
	}
	
	@Test
	public void testAtaqueNormalNoSeRealizaFueraDeRango() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(10,10);
		UnidadAtacante marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaFueraDeRango);
		
		assertEquals(false, marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaFueraDeRango)));
	}
	
	@Test
	public void testUnidadNoSeAtacaASiMisma() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		
		assertEquals(false, marineAtacante.atacar(marineAtacante, coordenadaAtacante.distanciaA(coordenadaAtacante)));
	}
	
	@Test
	public void testAtaqueNormalAireATierraSeRealiza() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacado = new Marine();
		UnidadAtacante espectroAtacante = new Espectro();
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		mapa.almacenar(espectroAtacante, coordenadaAtacante);
		
		assertEquals(true, espectroAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}
	
	@Test
	public void testAtaqueNormalTierraAAireNoSeRealizaSiLaUnidadNoInfligePuntosTerrestres() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante zealotAtacante = new Zealot();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenar(zealotAtacante, coordenadaAtacante);
		mapa.almacenar(naveAtacada, coordenadaEnRango);
		
		assertEquals(false, zealotAtacante.atacar(naveAtacada, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}


	@Test
	public void testAtaqueNormalTierraAAireSeRealiza() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(naveAtacada, coordenadaEnRango);
		
		assertEquals(true, marineAtacante.atacar(naveAtacada, coordenadaAtacante.distanciaA(coordenadaEnRango)));
	}
	
	@Test
	public void testUnidadNoAtacaAUnidadAmiga() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		
		marineAtacante.setColor(Colores.AZUL);
		marineAtacado.setColor(Colores.AZUL);		
		
		assertEquals(false, marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango)));
	}
	
	@Test
	public void testUnidadNoAtacaDosVecesEnMismoTurno() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		
		marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango));
		
		assertEquals(false, marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango)));
	}
	
	@Test
	public void testUnidadPuedeVolverAAtacarEnOtroTurno() 
			throws DestinoInvalidoException, FueraDeLimitesException, PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion {
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		
		marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango));
		marineAtacante.iniciarTurno();
		
		assertEquals(true, marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango)));
	}
	
	@Test
	public void testUnidadNoAtacaSiEstaMuerta() throws DestinoInvalidoException, FueraDeLimitesException, PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion{
		Mapa mapa = new Mapa(2,2);
		UnidadAtacante dragon = new Dragon();
		UnidadAtacante marine = new Marine();
		Coordenada coordenada1 = new Coordenada(1,1);
		Coordenada coordenada2 = new Coordenada(2,2);
		mapa.almacenar(dragon, coordenada1);
		mapa.almacenar(marine, coordenada2);
		
		dragon.atacar(marine, coordenada1.distanciaA(coordenada2));
		dragon.iniciarTurno();
		dragon.atacar(marine, coordenada1.distanciaA(coordenada2));
		
		assertEquals(false, marine.atacar(dragon, coordenada2.distanciaA(coordenada1)));
	}
}

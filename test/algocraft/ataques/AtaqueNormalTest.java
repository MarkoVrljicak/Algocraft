package algocraft.ataques;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.Zealot;
import algocraft.unidades.terran.Espectro;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

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
		Unidad marineAtacante = new Marine();
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
		Unidad marineAtacante = new Marine();
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
		Unidad marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(marineAtacado, coordenadaFueraDeRango);
		
		assertEquals(false, marineAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaFueraDeRango)));
	}
	
	@Test
	public void testUnidadNoSeAtacaASiMisma() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		
		assertEquals(false, marineAtacante.atacar(marineAtacante, coordenadaAtacante.distanciaA(coordenadaAtacante)));
	}
	
	@Test
	public void testAtaqueNormalAireATierraSeRealiza() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacado = new Marine();
		Unidad espectroAtacante = new Espectro();
		mapa.almacenar(marineAtacado, coordenadaEnRango);
		mapa.almacenar(espectroAtacante, coordenadaAtacante);
		
		assertEquals(true, espectroAtacante.atacar(marineAtacado, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}
	
	@Test
	public void testAtaqueNormalTierraAAireNoSeRealizaSiLaUnidadNoInfligePuntosTerrestres() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		Unidad zealotAtacante = new Zealot();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenar(zealotAtacante, coordenadaAtacante);
		mapa.almacenar(naveAtacada, coordenadaEnRango);
		
		assertEquals(false, zealotAtacante.atacar(naveAtacada, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}


	@Test
	public void testAtaqueNormalTierraAAireSeRealiza() 
			throws DestinoInvalidoException, FueraDeLimitesException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenar(marineAtacante, coordenadaAtacante);
		mapa.almacenar(naveAtacada, coordenadaEnRango);
		
		assertEquals(true, marineAtacante.atacar(naveAtacada, coordenadaAtacante.distanciaA(coordenadaEnRango)));
	}
}

package algocraft.ataques;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.unidades.Unidad;
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
	public void testAtaqueNormalTerrestreSeRealiza() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		mapa.almacenarEnSuelo(marineAtacado, coordenadaEnRango);
		
		//Puedo hacer esto porque se donde puse a los marines.
		//En realidad es Mapa quien tiene que suministrarle
		//la informacion al metodo atacar.
		
		assertEquals(true, marineAtacante.atacar(mapa.getTerreno(coordenadaEnRango), suelo, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}
	
	@Test
	public void testUnidadTerrestreRecibeDanioDeAtaqueNormal() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		mapa.almacenarEnSuelo(marineAtacado, coordenadaEnRango);
		
		marineAtacante.atacar(mapa.getTerreno(coordenadaEnRango), suelo, coordenadaAtacante.distanciaA(coordenadaEnRango));
		
		assertEquals(vidaMaximaMarine - danioMarine, marineAtacado.getVida());
	}
	
	@Test
	public void testAtaqueNormalNoSeRealizaFueraDeRango() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(10,10);
		Unidad marineAtacante = new Marine();
		Unidad marineAtacado = new Marine();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		mapa.almacenarEnSuelo(marineAtacado, coordenadaFueraDeRango);
		
		assertEquals(false, marineAtacante.atacar(mapa.getTerreno(coordenadaFueraDeRango), suelo, coordenadaAtacante.distanciaA(coordenadaFueraDeRango)));
	}
	
	@Test
	public void testAtaqueNormalNoSeRealizaSinOtraUnidad() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(10,10);
		Unidad marineAtacante = new Marine();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		
		marineAtacante.atacar(mapa.getTerreno(coordenadaEnRango), suelo, coordenadaAtacante.distanciaA(coordenadaEnRango));
		
		assertEquals(false, marineAtacante.atacar(mapa.getTerreno(coordenadaFueraDeRango), suelo, coordenadaAtacante.distanciaA(coordenadaFueraDeRango)));
	}
	
	@Test
	public void testUnidadNoSeAtacaASiMisma() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		
		assertEquals(false, marineAtacante.atacar(mapa.getTerreno(coordenadaAtacante), suelo, coordenadaAtacante.distanciaA(coordenadaAtacante)));
	}
	
	@Test
	public void testAtaqueNormalTierraAAireSeRealiza() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		mapa.almacenarEnCielo(naveAtacada, coordenadaEnRango);
		
		assertEquals(true, marineAtacante.atacar(mapa.getTerreno(coordenadaEnRango), cielo, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}
	
	@Test
	public void testAtaqueNormalAireATierraSeRealiza() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacado = new Marine();
		Unidad naveAtacante = new Espectro();
		mapa.almacenarEnSuelo(marineAtacado, coordenadaEnRango);
		mapa.almacenarEnCielo(naveAtacante, coordenadaAtacante);
		
		assertEquals(true, naveAtacante.atacar(mapa.getTerreno(coordenadaEnRango), suelo, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}

}

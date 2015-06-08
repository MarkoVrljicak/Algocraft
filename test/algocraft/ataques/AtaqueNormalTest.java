package algocraft.ataques;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.protos.Zealot;
import algocraft.unidades.Alternativas.terran.Marine;
import algocraft.unidades.Alternativas.terran.NaveCiencia;

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
	public void testAtaqueNormalNoSeRealizaSinOtraUnidad() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(10,10);
		Unidad marineAtacante = new Marine();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		
		marineAtacante.atacar(mapa.getTerreno(coordenadaEnRango), suelo, coordenadaAtacante.distanciaA(coordenadaEnRango));
		
		assertEquals(false, marineAtacante.atacar(mapa.getTerreno(coordenadaFueraDeRango), suelo, coordenadaAtacante.distanciaA(coordenadaFueraDeRango)));
	}
	
	@Test
	public void testAtaqueNormalTierraAAireNoSeRealizaSiLaUnidadNoInfligePuntosTerrestres() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad zealotAtacante = new Zealot();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenarEnSuelo(zealotAtacante, coordenadaAtacante);
		mapa.almacenarEnCielo(naveAtacada, coordenadaEnRango);
		
		assertEquals(false, zealotAtacante.atacar(mapa.getTerreno(coordenadaEnRango), cielo, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}

}

package algocraft.ataques;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.SectoresDeTerreno;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.terran.Marine;
import algocraft.unidades.Alternativas.terran.NaveCiencia;

public class AtaqueAereoTest {
	Coordenada coordenadaAtacante = new Coordenada(1,1);
	Coordenada coordenadaEnRango = new Coordenada(2,2);
	Coordenada coordenadaFueraDeRango = new Coordenada(10,10);
	
	int vidaMaximaMarine = 40;
	int vidaMaximaNave = 200;
	int danioMarine = 6;
	
	SectoresDeTerreno suelo = SectoresDeTerreno.SUELO;
	SectoresDeTerreno cielo = SectoresDeTerreno.CIELO;
	
	@Test
	public void testAtaqueNormalTierraAAireSeRealiza() throws DestinoInvalidoException {
		Mapa mapa = new Mapa(2,2);
		Unidad marineAtacante = new Marine();
		Unidad naveAtacada = new NaveCiencia();
		mapa.almacenarEnSuelo(marineAtacante, coordenadaAtacante);
		mapa.almacenarEnCielo(naveAtacada, coordenadaEnRango);
		
		assertEquals(true, marineAtacante.atacar(mapa.getTerreno(coordenadaEnRango), cielo, coordenadaAtacante.distanciaA(coordenadaEnRango)));

	}
}

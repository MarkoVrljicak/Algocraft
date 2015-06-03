package algocraft.unidades.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.terran.Golliat;

public class GolliatTest {

	@Test
	public void testCreoGolliatYControloSuVidaInicial() {
		
		Golliat golliat = new Golliat();
		
		assertEquals(125, golliat.getVida());
	}
}

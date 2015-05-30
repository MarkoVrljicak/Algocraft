package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabricaTest {

	@Test
	public void testConstruyoFabricaYControloSuVidaInicial() {
		Construccion construccion = new Fabrica();
		
		assertEquals(1250, construccion.getVida());
	}

	@Test
	public void testCreoGolliatYControloSuVidaInicial() {
		Fabrica construccion = new Fabrica();
		
		Golliat golliat = construccion.crearGolliat();
		
		assertEquals(125, golliat.getVida());
	}
}

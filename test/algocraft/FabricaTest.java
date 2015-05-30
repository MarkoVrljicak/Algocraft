package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabricaTest {

	@Test
	public void testConstruyoFabricaYControloSuVidaInicial() {
		Construccion construccion = new Fabrica();
		
		assertEquals(1250, construccion.getVida());
	}

}

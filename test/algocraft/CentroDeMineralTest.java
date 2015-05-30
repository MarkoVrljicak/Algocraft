package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentroDeMineralTest {

	@Test
	public void testConstruyoCentroDeMineralYControloSuVidaInicial() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(500, construccion.getVida());
	}

}

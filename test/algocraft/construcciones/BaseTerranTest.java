package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.terran.BaseTerran;

public class BaseTerranTest {
	@Test
	public void testConstruyoBaseTerranYControloSuVidaInicial() {
		Construccion construccion = new BaseTerran();
		
		assertEquals(2500, construccion.getVida());
	}

}

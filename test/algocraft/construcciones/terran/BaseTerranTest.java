package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.BaseTerran;

public class BaseTerranTest {
	@Test
	public void testConstruyoBaseTerranYControloSuVidaInicial() {
		Construccion construccion = new BaseTerran();
		
		assertEquals(2500, construccion.getVida());
	}

}

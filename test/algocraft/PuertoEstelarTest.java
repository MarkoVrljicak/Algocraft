package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuertoEstelarTest {

	@Test
	public void testConstruyoPuertoEstelarYControloSuVidaInicial() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(1300, construccion.getVida());
	}

}

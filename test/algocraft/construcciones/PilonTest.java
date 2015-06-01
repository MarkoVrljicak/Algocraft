package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PilonTest {
	
	@Test
	public void testConstruyoPilonYControloSuVidaInicial() {
		Construccion construccion = new Pilon();
		
		assertEquals(300, construccion.getVida());
	}
}

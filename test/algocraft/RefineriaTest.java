package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class RefineriaTest {

	@Test
	public void testConstruyoRefineriaYControloSuVidaInicial() {
			Construccion construccion = new Refineria();
			
			assertEquals(750, construccion.getVida());
	}

}

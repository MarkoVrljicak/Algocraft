package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AsimiladorTest {
	
	@Test
	public void testConstruyoAsimiladorYControloSuVidaInicial() {
			Construccion construccion = new Asimilador();
			
			assertEquals(450, construccion.getVida());
	}
}

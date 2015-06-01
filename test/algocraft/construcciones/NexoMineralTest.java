package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;


public class NexoMineralTest {
	
	@Test
	public void testConstruyoNexoMineralYControloSuVidaInicial() {
		Construccion construccion = new NexoMineral();
		
		assertEquals(250, construccion.getVida());
	}
	
}

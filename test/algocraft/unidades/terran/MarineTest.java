package algocraft.unidades.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.terran.Marine;

public class MarineTest {

	@Test
	public void testControloSuVidaInicial() {

		Marine marine = new Marine();
		
		assertEquals(40, marine.getVida());
	}
	
}

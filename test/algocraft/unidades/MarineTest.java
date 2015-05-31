package algocraft.unidades;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarineTest {

	@Test
	public void testControloSuVidaInicial() {

		Marine marine = new Marine();
		
		assertEquals(40, marine.getVida());
	}

}

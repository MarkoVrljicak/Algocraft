package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class BarracaTest {

	@Test
	public void testConstruyoBarracaYControloSuVidaInicial() {
		Construccion construccion = new Barraca();
		
		assertEquals(1000, construccion.getVida());
	}

	@Test
	public void testCreoMarineYControloSuVidaInicial() {
		Barraca construccion = new Barraca();
		
		Marine marine = construccion.crearMarine();
		
		assertEquals(40, marine.getVida());
	}
}

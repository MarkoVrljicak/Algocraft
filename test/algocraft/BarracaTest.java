package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class BarracaTest {

	@Test
	public void testConstruyoBarracaYControloSuVidaInicial(){
		Barraca construccion = new Barraca();
		
		assertEquals(1000, construccion.getVida());
	}

}
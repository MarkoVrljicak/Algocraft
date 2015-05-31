package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TierraTest {

	@Test
	public void testSePuedeCaminar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeCaminar() );
	}
	
	@Test
	public void testSePuedeVolar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeVolar() );
	}

}

package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TierraTest {

	@Test
	public void testTierraSePuedeCaminar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeCaminar() );
	}
	
	@Test
	public void testTierraSePuedeVolar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeVolar() );
	}
	
	@Test
	public void testTierraNoSePuedeMinar() {
		Tierra tierra = new Tierra();
		assertEquals(false, tierra.sePuedeMinar() );
	}
	
	@Test
	public void testTierraNoTieneGas() {
		Tierra tierra = new Tierra();
		assertEquals(false, tierra.hayGas() );
	}

}

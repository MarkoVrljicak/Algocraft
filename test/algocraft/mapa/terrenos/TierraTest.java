package algocraft.mapa.terrenos;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.mapa.terrenos.Tierra;

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
		assertEquals(false, tierra.tieneGas() );
	}
	
	@Test
	public void testTierraSePuedeEdificar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeEdificar());
	}

}

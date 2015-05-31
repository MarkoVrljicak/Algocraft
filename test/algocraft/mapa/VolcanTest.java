package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolcanTest {

	@Test
	public void testVolcanNoSePuedeCaminar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeCaminar());
	}

	@Test
	public void testVolcanNoSePuedeVolar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeVolar());
	}
	
	@Test
	public void testVolcanNoSePuedeMinar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeMinar());
	}
	
	@Test
	public void testVolcanTieneGas() {
		Volcan volcan = new Volcan();
		assertEquals(true, volcan.tieneGas());
	}
}

package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class MineralesTest {

	@Test
	public void testMineralesNoSePuedeCaminar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeCaminar());
	}
	
	@Test
	public void testMineralesNoSePuedeVolar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeVolar());
	}
	

}

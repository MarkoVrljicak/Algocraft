package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolcanTest {

	@Test
	public void testVolcanNoSePuedeCaminar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeCaminar());
	}

}

package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class MineralesTest {

	@Test
	public void testAireNoSePuedeCaminar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeCaminar());
	}

}

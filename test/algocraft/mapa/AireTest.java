package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class AireTest {

	@Test
	public void testAireNoSePuedeCaminar() {
		Aire aire = new Aire();
		assertEquals(false, aire.sePuedeCaminar());
		
	}

}

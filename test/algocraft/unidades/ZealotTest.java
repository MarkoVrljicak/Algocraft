package algocraft.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZealotTest {

	@Test
	public void testControloSuVidaInicial() {

		Zealot zealot = new Zealot();
		
		assertEquals(100, zealot.getVida());
	}
}

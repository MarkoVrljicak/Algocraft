package algocraft.unidades.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.protos.Zealot;

public class ZealotTest {

	@Test
	public void testControloSuVidaInicial() {

		Zealot zealot = new Zealot();
		
		assertEquals(100, zealot.getVida());
	}
}

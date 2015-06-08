package algocraft.unidades.Alternativas.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.Alternativas.protos.Zealot;


public class ZealotTest {

	@Test
	public void testControloSuVidaInicial() {

		Zealot zealot = new Zealot();
		
		assertEquals(100, zealot.getVida());
	}
	
	public void testZealotNoEsVolador(){
		Zealot zealot = new Zealot();
		assertEquals(false, zealot.soyVolador());
	}
}

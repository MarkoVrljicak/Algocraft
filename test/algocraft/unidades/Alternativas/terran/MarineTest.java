package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MarineTest {

	@Test
	public void testControloSuVidaInicial() {

		Marine marine = new Marine();
		
		assertEquals(40, marine.getVida());
	}
	
	public void testMarineNoEsVolador(){
		Marine marine = new Marine();
		assertEquals(false, marine.soyVolador());
	}

}

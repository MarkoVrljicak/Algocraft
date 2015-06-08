package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GolliatTest {

	@Test
	public void testCreoGolliatYControloSuVidaInicial() {
		
		Golliat golliat = new Golliat();
		
		assertEquals(125, golliat.getVida());
	}
	
	public void testGolliatNoEsVolador(){
		Golliat golliat = new Golliat();
		assertEquals(false, golliat.soyVolador());
	}
	
	
}

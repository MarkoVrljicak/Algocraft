package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;
import org.junit.Test;


public class GolliatTest {

	@Test
	public void testCreoGolliatYControloSuVidaInicial() {
		
		Golliat golliat = new Golliat();
		
		assertEquals(125, golliat.getVida());
	}
}

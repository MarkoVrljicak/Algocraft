package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;
import org.junit.Test;


public class EspectroTest {

	@Test
	public void testControloSuVidaInicial() {

		Espectro espectro = new Espectro();
		
		assertEquals(120, espectro.getVida());
	}

}
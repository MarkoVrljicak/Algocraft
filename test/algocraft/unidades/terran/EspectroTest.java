package algocraft.unidades.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.terran.Espectro;

public class EspectroTest {

	@Test
	public void testControloSuVidaInicial() {

		Espectro espectro = new Espectro();
		
		assertEquals(120, espectro.getVida());
	}

}

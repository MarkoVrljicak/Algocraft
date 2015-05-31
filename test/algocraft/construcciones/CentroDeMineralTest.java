package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.CentroDeMineral;

public class CentroDeMineralTest {

	@Test
	public void testConstruyoCentroDeMineralYControloSuVidaInicial() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(500, construccion.getVida());
	}
}

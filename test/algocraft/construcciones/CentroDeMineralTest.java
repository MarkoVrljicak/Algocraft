package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.terran.CentroDeMineral;

public class CentroDeMineralTest {

	@Test
	public void testConstruyoCentroDeMineralYControloSuVidaInicial() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(500, construccion.getVida());
	}

	@Test
	public void testVeoElTiempoDeConstruccionParaCrearCentroDeMineral() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(4, construccion.tiempoDeCreacion());
	}
	
}

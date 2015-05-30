package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentroDeMineralTest {

	@Test
	public void testConstruyoCentroDeMineralYControloSuVidaInicial() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(500, construccion.getVida());
	}

	@Test
	public void testVeoElCostoDeMineralParaCrearCentroDeMineral() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(50, construccion.costoMineral());		
	}
	
	@Test
	public void testVeoElCostoDeGasParaCrearCentroDeMineral() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(0, construccion.costoGas());
	}
}

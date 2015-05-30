package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Refineria;

public class RefineriaTest {

	@Test
	public void testConstruyoRefineriaYControloSuVidaInicial() {
			Construccion construccion = new Refineria();
			
			assertEquals(750, construccion.getVida());
	}

	@Test
	public void testVeoElCostoDeMineralParaCrearRefineria() {
		Construccion construccion = new Refineria();
		
		assertEquals(100, construccion.costoMineral());		
	}
	
	@Test
	public void testVeoElCostoDeGasParaCrearRefineria() {
		Construccion construccion = new Refineria();
		
		assertEquals(0, construccion.costoGas());
	}
}

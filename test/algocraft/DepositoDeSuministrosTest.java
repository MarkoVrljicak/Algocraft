package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class DepositoDeSuministrosTest {

	@Test
	public void testConstruyoDepositoDeSuministrosYControloSuVidaInicial() {
		Construccion construccion = new DepositoDeSuministros();
		
		assertEquals(500, construccion.getVida());
	}

	@Test
	public void testVeoElCostoDeMineralParaCrearDepositoDeSuministros() {
		Construccion construccion = new DepositoDeSuministros();
		
		assertEquals(100, construccion.costoMineral());		
	}
	
	@Test
	public void testVeoElCostoDeGasParaCrearDepositoDeSuministros() {
		Construccion construccion = new DepositoDeSuministros();
		
		assertEquals(0, construccion.costoGas());
	}
}

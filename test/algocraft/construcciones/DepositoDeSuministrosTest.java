package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.DepositoDeSuministros;

public class DepositoDeSuministrosTest {

	@Test
	public void testConstruyoDepositoDeSuministrosYControloSuVidaInicial() {
		Construccion construccion = new DepositoDeSuministros();
		
		assertEquals(500, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearDepositoDeSuministros() {
		Construccion construccion = new DepositoDeSuministros();
		
		assertEquals(6, construccion.tiempoDeCreacion());
	}
	
}

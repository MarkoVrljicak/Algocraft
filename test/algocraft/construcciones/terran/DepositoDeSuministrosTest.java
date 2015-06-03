package algocraft.construcciones.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.DepositoDeSuministros;

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

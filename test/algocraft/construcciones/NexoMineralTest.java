package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.protos.NexoMineral;


public class NexoMineralTest {
	
	@Test
	public void testConstruyoNexoMineralYControloSuVidaInicial() {
		Construccion construccion = new NexoMineral();
		
		assertEquals(250, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearNexoMineral() {
		Construccion construccion = new NexoMineral();
		
		assertEquals(4, construccion.tiempoDeCreacion());
	}
}

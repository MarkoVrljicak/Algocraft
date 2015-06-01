package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Fabrica;

public class FabricaTest {

	@Test
	public void testConstruyoFabricaYControloSuVidaInicial() {
		Construccion construccion = new Fabrica();
		
		assertEquals(1250, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearFabrica() {
		Construccion construccion = new Fabrica();
		
		assertEquals(12, construccion.tiempoDeCreacion());
	}
}


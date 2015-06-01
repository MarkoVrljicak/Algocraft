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
	public void testVeoElTiempoDeConstruccionParaCrearRefineria() {
		Construccion construccion = new Refineria();
		
		assertEquals(6, construccion.tiempoDeCreacion());
	}
}

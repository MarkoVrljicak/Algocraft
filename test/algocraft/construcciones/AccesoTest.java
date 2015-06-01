package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccesoTest {
	
	@Test
	public void testConstruyoAccesoYControloSuVidaInicial() {
		Construccion construccion = new Acceso();
		
		assertEquals(500, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearAcceso() {
		Construccion construccion = new Acceso();
		
		assertEquals(8, construccion.tiempoDeCreacion());
	}
}
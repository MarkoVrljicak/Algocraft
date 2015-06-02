package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.Pilon;

public class PilonTest {
	
	@Test
	public void testConstruyoPilonYControloSuVidaInicial() {
		Construccion construccion = new Pilon();
		
		assertEquals(300, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearPilon() {
		Construccion construccion =new Pilon();
		
		assertEquals(5, construccion.tiempoDeCreacion());
	}
}

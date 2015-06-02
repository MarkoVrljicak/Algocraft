package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.Asimilador;

public class AsimiladorTest {
	
	@Test
	public void testConstruyoAsimiladorYControloSuVidaInicial() {
			Construccion construccion = new Asimilador();
			
			assertEquals(450, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearAsimilador() {
		Construccion construccion = new Asimilador();
		
		assertEquals(6, construccion.tiempoDeCreacion());
	}
}

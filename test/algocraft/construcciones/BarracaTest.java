package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Barraca;

public class BarracaTest {

	@Test
	public void testConstruyoBarracaYControloSuVidaInicial() {
		Construccion construccion = new Barraca();
		
		assertEquals(1000, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearBarranca() {
		Construccion construccion = new Barraca();
		
		assertEquals(12, construccion.tiempoDeConstruccion());
	}
}

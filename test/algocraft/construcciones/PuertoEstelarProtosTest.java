package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.protos.PuertoEstelar;

public class PuertoEstelarProtosTest {

	@Test
	public void testConstruyoPuertoEstelarYControloSuVidaInicial() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(600, construccion.getVida());
	}

	@Test
	public void testVeoElTiempoDeConstruccionParaCrearPuertoEstelar() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(10, construccion.tiempoDeCreacion());
	}
}

package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuertoEstelarTest {

	@Test
	public void testConstruyoPuertoEstelarYControloSuVidaInicial() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(1300, construccion.getVida());
	}

	@Test
	public void testCreoEspectroYControloSuVidaInicial() {
		PuertoEstelar construccion = new PuertoEstelar();
		
		Espectro espectro = construccion.crearEspectro();
		
		assertEquals(120, espectro.getVida());
	}
	
	@Test
	public void testCreoNaveCienciaYControloSuVidaInicial() {
		PuertoEstelar construccion = new PuertoEstelar();
		
		NaveCiencia naveciencia = construccion.crearNaveCiencia();
		
		assertEquals(200, naveciencia.getVida());
	}
}

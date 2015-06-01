package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.PuertoEstelar;

public class PuertoEstelarTest {

	@Test
	public void testConstruyoPuertoEstelarYControloSuVidaInicial() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(1300, construccion.getVida());
	}

	@Test
	public void testVeoElTiempoDeConstruccionParaCrearPuertoEstelar() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(10, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testPuertoEstelarInicializaConEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad("Espectro"));
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad("Nave Ciencia"));
	}
}

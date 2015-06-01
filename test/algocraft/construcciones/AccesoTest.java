package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccesoTest {
	
	private String nombreZealot="Zealot";
	private String nombreDragon="Dragon";

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
	
	@Test
	public void testAccesoInicializaConZealot() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(nombreZealot));
	}
	
	@Test
	public void testAccesoInicializaConDragon() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(nombreDragon));
	}
}

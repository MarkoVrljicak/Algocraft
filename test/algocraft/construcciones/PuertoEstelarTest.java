package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.PuertoEstelar;
import algocraft.unidades.Unidad;

public class PuertoEstelarTest {

	private int muchoMineral = 999;
	private int muchoGas = 999;
	
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
	
	@Test
	public void testPuertoEstelarInicializaConNaveTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad("Nave Transporte"));
	}
	
	@Test
	public void testPuertoEstelarCreaEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Unidad espectro = puertoEstelar.crearUnidad(muchoMineral, muchoGas, "Espectro");
		
		assertEquals("Espectro", espectro.getNombre());
	}
	
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Unidad nave = puertoEstelar.crearUnidad(muchoMineral, muchoGas, "Nave Transporte");
		
		assertEquals("Nave Transporte", nave.getNombre());
	}
	
	@Test
	public void testPuertoEstelarCreaNaveCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Unidad nave = puertoEstelar.crearUnidad(muchoMineral, muchoGas, "Nave Ciencia");
		
		assertEquals("Nave Ciencia", nave.getNombre());
	}
}

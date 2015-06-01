package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Fabrica;
import algocraft.unidades.Unidad;

public class FabricaTest {
	public int muchoMineral = 999;
	public int muchoGas = 999;
	String nombreGolliat = "Golliat";

	@Test
	public void testConstruyoFabricaYControloSuVidaInicial() {
		Construccion construccion = new Fabrica();
		
		assertEquals(1250, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearFabrica() {
		Construccion construccion = new Fabrica();
		
		assertEquals(12, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testFabriInicializaConGolliat() {
		Fabrica fabrica = new Fabrica();
		
		assertEquals(true, fabrica.tengoUnidad(nombreGolliat));
	}
	
	@Test
	public void testFabricaCreaGolliat() {
		Fabrica fabrica = new Fabrica();
		Unidad golliat = fabrica.crearUnidad(muchoMineral, muchoGas, nombreGolliat);
		
		assertEquals(nombreGolliat, golliat.getNombre());
	}
}


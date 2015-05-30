package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Barraca;
import algocraft.unidades.Marine;

public class BarracaTest {

	@Test
	public void testConstruyoBarracaYControloSuVidaInicial() {
		Construccion construccion = new Barraca();
		
		assertEquals(1000, construccion.getVida());
	}

	@Test
	public void testCreoMarineYControloSuVidaInicial() {
		Barraca construccion = new Barraca();
		
		Marine marine = construccion.crearMarine();
		
		assertEquals(40, marine.getVida());
	}
	
	@Test
	public void testVeoElCostoDeMineralParaCrearBarraca() {
		Construccion construccion = new Barraca();
		
		assertEquals(150, construccion.costoMineral());		
	}
	
	@Test
	public void testVeoElCostoDeGasParaCrearBarraca() {
		Construccion construccion = new Barraca();
		
		assertEquals(0, construccion.costoGas());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearBarranca() {
		Construccion construccion = new Barraca();
		
		assertEquals(12, construccion.tiempoDeConstruccion());
	}
}

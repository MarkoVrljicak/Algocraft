package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Fabrica;
import algocraft.unidades.Golliat;

public class FabricaTest {

	@Test
	public void testConstruyoFabricaYControloSuVidaInicial() {
		Construccion construccion = new Fabrica();
		
		assertEquals(1250, construccion.getVida());
	}

	@Test
	public void testCreoGolliatYControloSuVidaInicial() {
		Fabrica construccion = new Fabrica();
		
		Golliat golliat = construccion.crearGolliat();
		
		assertEquals(125, golliat.getVida());
	}
	
	@Test
	public void testVeoElCostoDeMineralParaCrearFabrica() {
		Construccion construccion = new Fabrica();
		
		assertEquals(200, construccion.costoMineral());		
	}
	
	@Test
	public void testVeoElCostoDeGasParaCrearFabrica() {
		Construccion construccion = new Fabrica();
		
		assertEquals(100, construccion.costoGas());
	}
}


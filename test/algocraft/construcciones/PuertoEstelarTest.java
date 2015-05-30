package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.Espectro;
import algocraft.construcciones.PuertoEstelar;
import algocraft.unidades.NaveCiencia;
import algocraft.unidades.NaveTransporte;

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
	
	@Test
	public void testCreoNaveTransporteYControloSuVidaInicial() {
		PuertoEstelar construccion = new PuertoEstelar();
		
		NaveTransporte navetransporte = construccion.crearNaveTransporte();
		
		assertEquals(150, navetransporte.getVida());
	}
	
	@Test
	public void testVeoElCostoDeMineralParaCrearPuertoEstelar() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(150, construccion.costoMineral());		
	}
	
	@Test
	public void testVeoElCostoDeGasParaCrearPuertoEstelar() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(100, construccion.costoGas());
	}
}

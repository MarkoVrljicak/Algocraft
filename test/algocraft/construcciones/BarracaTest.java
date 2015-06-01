package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Barraca;
import algocraft.unidades.Unidad;

public class BarracaTest {
	public int muchoMineral = 999;
	public int muchoGas = 999;
	public String nombreMarine = "Marine";

	@Test
	public void testConstruyoBarracaYControloSuVidaInicial() {
		Construccion construccion = new Barraca();
		
		assertEquals(1000, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearBarraca() {
		Construccion construccion = new Barraca();
		
		assertEquals(12, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testBarracaInicializaConMarine() {
		Barraca barraca = new Barraca();
		
		assertEquals(true, barraca.tengoUnidad(nombreMarine));
	}
	
	@Test
	public void testBarracaCreaMarine() {
		Barraca barraca = new Barraca();
		Unidad marine = barraca.crearUnidad(muchoMineral, muchoGas, nombreMarine);
		
		assertEquals(nombreMarine, marine.getNombre());
	}
}

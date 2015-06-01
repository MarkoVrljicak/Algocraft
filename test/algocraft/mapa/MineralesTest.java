package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class MineralesTest {

	@Test
	public void testMineralesNoSePuedeCaminar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeCaminar());
	}
	
	@Test
	public void testMineralesNoSePuedeVolar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeVolar());
	}
	
	@Test
	public void testMineralesSePuedenMinar() {
		Minerales minerales = new Minerales();
		assertEquals(true, minerales.sePuedeMinar());
	}
	
	@Test
	public void testMineralesNoTienenGas() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.tieneGas());
	}
	
	@Test
	public void testMineralesNoSePuedeEdificar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeEdificar());
	}
	

}

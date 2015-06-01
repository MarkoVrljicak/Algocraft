package algocraft.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class AireTest {

	@Test
	public void testAireNoSePuedeCaminar() {
		Aire aire = new Aire();
		assertEquals(false, aire.sePuedeCaminar());
	}

	@Test
	public void testAireSePuedeVolar() {
		Aire aire = new Aire();
		assertEquals(true, aire.sePuedeVolar());
	}
	
	@Test
	public void testAireNoSePuedeMinar() {
		Aire aire = new Aire();
		assertEquals(false, aire.sePuedeMinar());
	}
	
	@Test
	public void testAireNoTieneGas() {
		Aire aire = new Aire();
		assertEquals(false, aire.tieneGas());
	}
	
	@Test
	public void testAireNoSePuedeEdificar() {
		Aire aire = new Aire();
		assertEquals(false, aire.sePuedeEdificar());
	}
	
}

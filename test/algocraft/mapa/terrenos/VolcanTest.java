package algocraft.mapa.terrenos;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;
import algocraft.mapa.terrenos.Volcan;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class VolcanTest {

	@Test
	public void testVolcanNoSePuedeCaminar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeCaminar());
	}

	@Test
	public void testVolcanSePuedeVolar() {
		Volcan volcan = new Volcan();
		assertEquals(true, volcan.sePuedeVolar());
	}
	
	@Test
	public void testMineralesNoSePuedeVolarSiEstaLleno() {
		Volcan volcan = new Volcan();
		Creable nave = new NaveCiencia();
		
		try {
			volcan.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, volcan.sePuedeVolar());
	}
	
	@Test
	public void testVolcanNoSePuedeMinar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeMinar());
	}
	
	@Test
	public void testVolcanTieneGas() {
		Volcan volcan = new Volcan();
		assertEquals(true, volcan.tieneGas());
	}
	
	@Test
	public void testVolcanNoSePuedeEdificar() {
		Volcan volcan = new Volcan();
		assertEquals(false, volcan.sePuedeEdificar());
	}
	
	@Test
	public void testVolcanInicializaConCieloVacio(){
		Volcan volcan = new Volcan();
		
		assertEquals(null, volcan.getContenidoCielo());
	}
	
	@Test
	public void testVolcanInicializaConSueloVacio(){
		Volcan volcan = new Volcan();

		assertEquals(null, volcan.getContenidoSuelo());
	}
	
	@Test
	public void testColocaCreableEnCieloSiEstaVacio(){
		Volcan volcan = new Volcan();
		Creable nave = new NaveCiencia();
		
		try {
			volcan.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, volcan.getContenidoCielo());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnCieloSiEstaLleno() throws PosicionInvalidaException{
		Volcan volcan = new Volcan();
		Creable nave1 = new NaveCiencia();
		Creable nave2 = new NaveCiencia();
		
		volcan.almacenarEnCielo(nave1);
		volcan.almacenarEnCielo(nave2);
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnTierraAunqueEsteVacio() throws PosicionInvalidaException{
		Volcan volcan = new Volcan();
		Creable marine = new Marine();
		
		volcan.almacenarEnSuelo(marine);
	}
	
}

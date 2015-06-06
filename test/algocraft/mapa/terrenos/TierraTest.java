package algocraft.mapa.terrenos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class TierraTest {

	@Test
	public void testTierraSePuedeCaminar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeCaminar() );
	}
	
	@Test
	public void testTierraNoSePuedeCaminarConSueloOcupado() {
		Tierra tierra = new Tierra();
		Marine marine = new Marine();
		
		try {
			tierra.almacenarEnSuelo(marine);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, tierra.sePuedeCaminar() );
	}
	
	@Test
	public void testTierraSePuedeVolar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeVolar() );
	}
	
	@Test
	public void testTierraNoSePuedeVolarConCieloOcupado() {
		Tierra tierra = new Tierra();
		Creable nave = new NaveCiencia();
		
		try {
			tierra.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, tierra.sePuedeVolar() );
	}
	
	@Test
	public void testTierraNoSePuedeMinar() {
		Tierra tierra = new Tierra();
		assertEquals(false, tierra.sePuedeMinar() );
	}
	
	@Test
	public void testTierraNoTieneGas() {
		Tierra tierra = new Tierra();
		assertEquals(false, tierra.tieneGas() );
	}
	
	@Test
	public void testTierraSePuedeEdificar() {
		Tierra tierra = new Tierra();
		assertEquals(true, tierra.sePuedeEdificar());
	}
	
	@Test
	public void testTierraInicializaConCieloVacio(){
		Tierra tierra = new Tierra();
		
		assertEquals(null, tierra.getContenidoCielo());
	}
	
	@Test
	public void testTierraInicializaConSueloVacio(){
		Tierra tierra = new Tierra();
		
		assertEquals(null, tierra.getContenidoSuelo());
	}
	
	@Test
	public void testColocaCreableEnCieloSiEstaVacio(){
		Tierra tierra = new Tierra();
		Creable nave = new NaveCiencia();
		
		try {
			tierra.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, tierra.getContenidoCielo());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnCieloSiEstaLleno() throws PosicionInvalidaException{
		Tierra tierra = new Tierra();
		Creable nave1 = new NaveCiencia();
		Creable nave2 = new NaveCiencia();
		
		tierra.almacenarEnCielo(nave1);
		tierra.almacenarEnCielo(nave2);
	}
	
	@Test
	public void testColocaCreableEnSueloSiEstaVacio(){
		Tierra tierra = new Tierra();
		Marine marine = new Marine();
		
		try {
			tierra.almacenarEnSuelo(marine);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, tierra.getContenidoSuelo());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnSueloSiEstaLleno() throws PosicionInvalidaException{
		Tierra tierra = new Tierra();
		Marine marine1 = new Marine();
		Marine marine2 = new Marine();
		
		tierra.almacenarEnCielo(marine1);
		tierra.almacenarEnCielo(marine2);
	}
	


}

package algocraft.mapa.terrenos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

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
	public void testAireNoSePuedeVolarSiEstaLleno() {
		Aire aire = new Aire();
		Creable nave = new NaveCiencia();
		
		try {
			aire.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, aire.sePuedeVolar());
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
	
	@Test
	public void testAireInicializaConCieloVacio(){
		Aire aire = new Aire();
		
		assertEquals(null, aire.getContenidoCielo());
	}
	
	@Test
	public void testAireInicializaConSueloVacio(){
		Aire aire = new Aire();
		
		assertEquals(null, aire.getContenidoSuelo());
	}
	
	@Test
	public void testColocaCreableEnCieloSiEstaVacio(){
		Aire aire = new Aire();
		Creable nave = new NaveCiencia();
		
		try {
			aire.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, aire.getContenidoCielo());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnCieloSiEstaLleno() throws PosicionInvalidaException{
		Aire aire = new Aire();
		Creable nave1 = new NaveCiencia();
		Creable nave2 = new NaveCiencia();
		
		aire.almacenarEnCielo(nave1);
		aire.almacenarEnCielo(nave2);
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnTierraAunqueEsteVacio() throws PosicionInvalidaException{
		Aire aire = new Aire();
		Creable marine = new Marine();
		
		aire.almacenarEnSuelo(marine);
	}
	
	
	
}

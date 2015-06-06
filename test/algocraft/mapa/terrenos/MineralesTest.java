package algocraft.mapa.terrenos;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.creables.Creable;
import algocraft.exception.PosicionInvalidaException;
import algocraft.mapa.terrenos.Minerales;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class MineralesTest {

	@Test
	public void testMineralesNoSePuedeCaminar() {
		Minerales minerales = new Minerales();
		assertEquals(false, minerales.sePuedeCaminar());
	}
	
	@Test
	public void testMineralesSePuedeVolar() {
		Minerales minerales = new Minerales();
		assertEquals(true, minerales.sePuedeVolar());
	}
	
	@Test
	public void testMineralesNoSePuedeVolarSiEstaLleno() {
		Minerales minerales = new Minerales();
		Creable nave = new NaveCiencia();
		
		try {
			minerales.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
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
	
	@Test
	public void testMineralesInicializaConCieloVacio(){
		Minerales minerales = new Minerales();
		
		assertEquals(null, minerales.getContenidoCielo());
	}
	
	@Test
	public void testMineralesInicializaConSueloVacio(){
Minerales minerales = new Minerales();
		
		assertEquals(null, minerales.getContenidoSuelo());
	}
	
	@Test
	public void testColocaCreableEnCieloSiEstaVacio(){
		Minerales minerales = new Minerales();
		Creable nave = new NaveCiencia();
		
		try {
			minerales.almacenarEnCielo(nave);
		} catch (PosicionInvalidaException e) {
			e.printStackTrace();
		}
		
		assertEquals(nave, minerales.getContenidoCielo());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnCieloSiEstaLleno() throws PosicionInvalidaException{
		Minerales minerales = new Minerales();
		Creable nave1 = new NaveCiencia();
		Creable nave2 = new NaveCiencia();
		
		minerales.almacenarEnCielo(nave1);
		minerales.almacenarEnCielo(nave2);
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void testNoColocaCreableEnTierraAunqueEsteVacio() throws PosicionInvalidaException{
		Minerales minerales = new Minerales();
		Creable marine = new Marine();
		
		minerales.almacenarEnSuelo(marine);
	}
	

}

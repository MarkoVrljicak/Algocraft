package algocraft;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import razasAlternativas.Terran;

public class IntegracionTerransTest {
	
	private static final EnumEdificiosTerran nombreBarraca= EnumEdificiosTerran.BARRACA;
	private static final EnumEdificiosTerran nombreCentroDeMineral= EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreDepositoDeSuministros= EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS;
	private static final EnumEdificiosTerran nombreFabrica= EnumEdificiosTerran.FABRICA;
	private static final EnumEdificiosTerran nombrePuertoEstelar= EnumEdificiosTerran.PUERTO_ESTELAR;
	private static final EnumEdificiosTerran nombreRefineria= EnumEdificiosTerran.REFINERIA;

	@Test
	public void testCrearCentroDeMineral() {
		Jugador jugador = new Jugador("pepe", new Terran());
		jugador.construir( nombreCentroDeMineral);
		
		assertTrue(jugador.tieneConstruccion(nombreCentroDeMineral));
	}
	
	@Test
	public void testCrearBarraca() {
		Jugador jugador = new Jugador("pepe", new Terran());
		jugador.construir( nombreBarraca);
		
		assertTrue(jugador.tieneConstruccion(nombreBarraca));
	}
	
	@Test
	public void testCrearDepositoDeSuministros() {
		Jugador jugador = new Jugador("pepe", new Terran());
		jugador.construir( nombreDepositoDeSuministros);
		
		assertTrue(jugador.tieneConstruccion(nombreDepositoDeSuministros));
	}
	
	@Test
	public void testCrearRefineria() {
		Jugador jugador = new Jugador("pepe", new Terran());
		jugador.construir(nombreRefineria);
		
		assertTrue(jugador.tieneConstruccion(nombreRefineria));
	}
	
	@Test
	public void testCrearFabrica() {
		Jugador jugador = new Jugador("pepe", new Terran());
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.pasarTurno();
		}
		//creo edificios necesarios
		jugador.construir(nombreBarraca);
		
		//creo fabrica
		jugador.construir(nombreFabrica);
		
		assertTrue(jugador.tieneConstruccion(nombreFabrica));
	}
	
	@Test
	public void testNoSeCreaFabricaSinBarraca() {
		Jugador jugador = new Jugador("pepe", new Terran());
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.pasarTurno();
		}
		
		
		//creo fabrica sin tener barraca
		jugador.construir(nombreFabrica);
		
		assertFalse(jugador.tieneConstruccion(nombreFabrica));
	}
	
	@Test
	public void testCrearPuertoEstelar() {
		Jugador jugador = new Jugador("pepe", new Terran());
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.pasarTurno();
		}
		//creo edificios necesarios
		jugador.construir(nombreBarraca);
		jugador.construir(nombreFabrica);

		//creo puerto estelar
		jugador.construir( nombrePuertoEstelar);
		
		assertTrue(jugador.tieneConstruccion(nombrePuertoEstelar));
	}
	
	@Test
	public void testNoSeCreaPuertoEstelarSinFabrica() {
		Jugador jugador = new Jugador("pepe", new Terran());
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.pasarTurno();
		}

		//creo puerto estelar
		jugador.construir( nombrePuertoEstelar);
		
		assertFalse(jugador.tieneConstruccion(nombrePuertoEstelar));
	}

}

package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.terran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;

public class IntegracionTerransTest {
	
	

	@Test
	public void testCrearCentroDeMineral() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		jugador.construir( EnumEdificiosTerran.CENTRO_DE_MINERALES);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.CENTRO_DE_MINERALES));
	}
	
	@Test
	public void testCrearBarraca() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		jugador.construir( EnumEdificiosTerran.BARRACA);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.BARRACA));
	}
	
	@Test
	public void testCrearDepositoDeSuministros() {
		Jugador jugador = new Jugador("pepe", new Terran(),Colores.AZUL);
		jugador.construir( EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS));
	}
	
	@Test
	public void testCrearRefineria() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.REFINERIA));
	}
	
	@Test
	public void testCrearFabrica() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios necesarios
		jugador.construir(EnumEdificiosTerran.BARRACA);
		
		//creo fabrica
		jugador.construir(EnumEdificiosTerran.FABRICA);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.FABRICA));
	}
	
	@Test
	public void testNoSeCreaFabricaSinBarraca() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		
		
		//creo fabrica sin tener barraca
		jugador.construir(EnumEdificiosTerran.FABRICA);
		
		assertFalse(jugador.tieneConstruccion(EnumEdificiosTerran.FABRICA));
	}
	
	@Test
	public void testCrearPuertoEstelar() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios necesarios
		jugador.construir(EnumEdificiosTerran.BARRACA);
		jugador.construir(EnumEdificiosTerran.FABRICA);

		//creo puerto estelar
		jugador.construir( EnumEdificiosTerran.PUERTO_ESTELAR);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.PUERTO_ESTELAR));
	}
	
	@Test
	public void testNoSeCreaPuertoEstelarSinFabrica() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}

		//creo puerto estelar
		jugador.construir( EnumEdificiosTerran.PUERTO_ESTELAR);
		
		assertFalse(jugador.tieneConstruccion(EnumEdificiosTerran.PUERTO_ESTELAR));
	}

}

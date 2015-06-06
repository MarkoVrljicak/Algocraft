package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;

public class DepositoDeSuministrosTest {

	@Test
	public void testRecolectoMineral() {
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		deposito.aumentarPoblacion(jugador.getPoblacion());
		
		assertEquals(10 , jugador.getPoblacion().maxima());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		deposito.setDuenio(jugador);
		deposito.pasarTurno();
		
		assertEquals(10 , jugador.getPoblacion().maxima());
	}

}

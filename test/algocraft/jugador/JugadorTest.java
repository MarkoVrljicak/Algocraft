package algocraft.jugador;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;

public class JugadorTest {

	@Test
	public void jugadorTerranEmpiezaConPoblacionUno() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(1, jugadorTerran.poblacion());
	}

}

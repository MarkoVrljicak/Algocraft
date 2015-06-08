package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import algocraft.construccionesAlternativas.terran.Refineria;
import razas.Terran;

public class RefineriaTest {

	@Test
	public void testRecolectoGas() {
		Refineria refineria = new Refineria();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		refineria.recolectarGas(jugador.getRecursos());
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		Refineria refineria = new Refineria();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		refineria.setDuenio(jugador);
		refineria.pasarTurno();
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
}

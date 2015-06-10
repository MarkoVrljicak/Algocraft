package algocraft.construccionesAlternativas.terran;

import static org.junit.Assert.assertEquals;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import razasAlternativas.Terran;


public class RefineriaTest {

	@Test
	public void testRecolectoGas() {
		Refineria refineria = new Refineria();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		refineria.recolectarGas(jugador.getRecursos());
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		Refineria refineria = new Refineria();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		refineria.setDuenio(jugador);
		refineria.iniciarTurno();
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
}

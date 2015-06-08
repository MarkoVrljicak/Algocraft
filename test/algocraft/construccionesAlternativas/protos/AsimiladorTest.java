package algocraft.construccionesAlternativas.protos;

import static org.junit.Assert.*;
import jugador.Jugador;
import org.junit.Test;
import razasAlternativas.Protoss;


public class AsimiladorTest {
	
	@Test
	public void testRecolectoGas() {
		Asimilador asimilador = new Asimilador();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		asimilador.recolectarGas(jugador.getRecursos());
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		Asimilador asimilador = new Asimilador();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		asimilador.setDuenio(jugador);
		asimilador.pasarTurno();
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
}

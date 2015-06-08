package algocraft.construccionesAlternativas.protos;

import static org.junit.Assert.*;
import jugador.Jugador;
import org.junit.Test;
import razasAlternativas.Protoss;

public class NexoMineralTest {

	@Test
	public void testRecolectoMineral() {
		NexoMineral nexo = new NexoMineral();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		nexo.recolectarMineral(jugador.getRecursos());
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		NexoMineral nexo = new NexoMineral();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		nexo.setDuenio(jugador);
		nexo.pasarTurno();
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
}

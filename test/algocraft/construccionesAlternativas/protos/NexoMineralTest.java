package algocraft.construccionesAlternativas.protos;

import static org.junit.Assert.assertEquals;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import razasAlternativas.Protoss;

public class NexoMineralTest {
	Colores colorAzul = Colores.AZUL;
	
	@Test
	public void testRecolectoMineral() {
		NexoMineral nexo = new NexoMineral();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		nexo.recolectarMineral(jugador.getRecursos());
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		NexoMineral nexo = new NexoMineral();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);		
		nexo.setDuenio(jugador);
		nexo.iniciarTurno();
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
}

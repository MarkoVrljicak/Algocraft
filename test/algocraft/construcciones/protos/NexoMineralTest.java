package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.NexoMineral;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;

public class NexoMineralTest {
	
	
	@Test
	public void testRecolectoMineral() {
		NexoMineral nexo = new NexoMineral();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		nexo.recolectarMineral(jugador.getRecursos());
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		NexoMineral nexo = new NexoMineral();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);		
		nexo.setDuenio(jugador);
		nexo.iniciarTurno();
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
}

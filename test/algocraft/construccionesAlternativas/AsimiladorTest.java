package algocraft.construccionesAlternativas;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import org.junit.Test;
import razas.Protoss;
import algocraft.construccionesAlternativas.protos.Asimilador;

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

package algocraft.construccionesAlternativas.protos;

import static org.junit.Assert.assertEquals;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import razasAlternativas.Protoss;


public class AsimiladorTest {
	Colores colorAzul = Colores.AZUL;
	
	@Test
	public void testRecolectoGas() {
		Asimilador asimilador = new Asimilador();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		asimilador.recolectarGas(jugador.getRecursos());
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		Asimilador asimilador = new Asimilador();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		asimilador.setDuenio(jugador);
		asimilador.pasarTurno();
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
}

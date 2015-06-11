package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.Asimilador;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;


public class AsimiladorTest {
	
	
	@Test
	public void testRecolectoGas() {
		Asimilador asimilador = new Asimilador();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		asimilador.recolectarGas(jugador.getRecursos());
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		Asimilador asimilador = new Asimilador();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		asimilador.setDuenio(jugador);
		asimilador.iniciarTurno();
		
		assertEquals(10 , jugador.getRecursos().obtenerGas());
	}
}

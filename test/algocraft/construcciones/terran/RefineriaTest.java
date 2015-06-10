package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.terran.Refineria;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;


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

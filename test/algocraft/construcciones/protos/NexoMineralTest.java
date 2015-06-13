package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algocraft.construcciones.RecolectorMineral;
import algocraft.factory.edificiosProtoss.CreadorNexoMineral;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;

public class NexoMineralTest {
	
	@Test
	public void testRecolectoMineral() {
		CreadorNexoMineral creador = new CreadorNexoMineral();
		RecolectorMineral nexo = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		nexo.recolectarMineral(jugador.getRecursos());
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		CreadorNexoMineral creador = new CreadorNexoMineral();
		RecolectorMineral nexo = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);		
		nexo.setDuenio(jugador);
		nexo.iniciarTurno();
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
}

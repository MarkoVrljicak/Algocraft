package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.RecolectorMineral;
import algocraft.factory.edificiosProtoss.CreadorNexoMineral;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.EnumRazas;

public class NexoMineralTest {
	
	private Jugador nuevoJugadorProtos() {
		return new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
	}
	
	@Test
	public void testRecolectoMineral() {
		CreadorNexoMineral creador = new CreadorNexoMineral();
		RecolectorMineral nexo = creador.crearEdificio();
		Jugador jugador = nuevoJugadorProtos();
		
		nexo.recolectarMineral(jugador);
		
		assertEquals(210 , jugador.getMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		CreadorNexoMineral creador = new CreadorNexoMineral();
		RecolectorMineral nexo = creador.crearEdificio();
		Jugador jugador = nuevoJugadorProtos();		
		nexo.setDuenio(jugador);
		nexo.iniciarTurno();
		
		assertEquals(210 , jugador.getMineral());
	}
}

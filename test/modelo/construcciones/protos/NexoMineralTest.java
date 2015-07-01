package modelo.construcciones.protos;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.RecolectorMineral;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.factory.edificiosProtoss.CreadorNexoMineral;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;

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
	public void testPasoDeTurnoYRecolectoMineral() throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion {
		CreadorNexoMineral creador = new CreadorNexoMineral();
		RecolectorMineral nexo = creador.crearEdificio();
		Jugador jugador = nuevoJugadorProtos();		
		nexo.setDuenio(jugador);
		nexo.iniciarTurno();
		
		assertEquals(210 , jugador.getMineral());
	}
}

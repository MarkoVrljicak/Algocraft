package modelo.construcciones.protos;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.RecolectorGas;
import modelo.factory.edificiosProtoss.CreadorAsimilador;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;

public class AsimiladorTest {
	
	@Test
	public void testRecolectoGas() {
		CreadorAsimilador creador = new CreadorAsimilador();
		RecolectorGas asimilador = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		asimilador.recolectarGas(jugador);
		
		assertEquals(10 , jugador.getGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		CreadorAsimilador creador = new CreadorAsimilador();
		RecolectorGas asimilador = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		asimilador.setDuenio(jugador);
		asimilador.iniciarTurno();
		
		assertEquals(10 , jugador.getGas());
	}
}

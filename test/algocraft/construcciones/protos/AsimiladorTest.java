package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.RecolectorGas;
import algocraft.factory.edificiosProtoss.CreadorAsimilador;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.EnumRazas;

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

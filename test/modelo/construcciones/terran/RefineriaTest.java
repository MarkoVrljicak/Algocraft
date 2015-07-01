package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.RecolectorGas;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.factory.edificiosTerran.CreadorRefineria;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;


public class RefineriaTest {

	@Test
	public void testRecolectoGas() {
		CreadorRefineria creador = new CreadorRefineria();
		RecolectorGas refineria = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		refineria.recolectarGas(jugador);
		
		assertEquals(10 , jugador.getGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() throws PropiedadNoEstaEnJuegoException, PropiedadNoExisteEnEstaUbicacion {
		CreadorRefineria creador = new CreadorRefineria();
		RecolectorGas refineria = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		refineria.setDuenio(jugador);
		refineria.iniciarTurno();
		
		assertEquals(10 , jugador.getGas());
	}
}

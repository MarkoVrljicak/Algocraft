package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.RecolectorMineral;
import modelo.factory.edificiosTerran.CreadorCentroDeMineral;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;


public class CentroDeMineralTest {

	@Test
	public void testRecolectoMineral() {
		CreadorCentroDeMineral creador = new CreadorCentroDeMineral();
		RecolectorMineral centroDeMineral = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN,Colores.AZUL);
		
		centroDeMineral.recolectarMineral(jugador);
		
		assertEquals(210 , jugador.getMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		CreadorCentroDeMineral creador = new CreadorCentroDeMineral();
		RecolectorMineral centroDeMineral = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		centroDeMineral.setDuenio(jugador);
		centroDeMineral.iniciarTurno();
		
		assertEquals(210 , jugador.getMineral());
	}
}

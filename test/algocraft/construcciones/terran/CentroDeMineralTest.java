package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algocraft.construcciones.RecolectorMineral;
import algocraft.factory.edificiosTerran.CreadorCentroDeMineral;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;


public class CentroDeMineralTest {

	@Test
	public void testRecolectoMineral() {
		CreadorCentroDeMineral creador = new CreadorCentroDeMineral();
		RecolectorMineral centroDeMineral = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(),Colores.AZUL);
		
		centroDeMineral.recolectarMineral(jugador);
		
		assertEquals(210 , jugador.getMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		CreadorCentroDeMineral creador = new CreadorCentroDeMineral();
		RecolectorMineral centroDeMineral = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		centroDeMineral.setDuenio(jugador);
		centroDeMineral.iniciarTurno();
		
		assertEquals(210 , jugador.getMineral());
	}
}

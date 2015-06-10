package algocraft.construcciones.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.terran.CentroDeMineral;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;


public class CentroDeMineralTest {

	@Test
	public void testRecolectoMineral() {
		CentroDeMineral centro = new CentroDeMineral();
		Jugador jugador = new Jugador("Nombre", new Terran(),Colores.AZUL);
		
		centro.recolectarMineral(jugador.getRecursos());
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		CentroDeMineral centro = new CentroDeMineral();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		centro.setDuenio(jugador);
		centro.iniciarTurno();
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
}

package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;
import jugador.Jugador;
import org.junit.Test;
import algocraft.construccionesAlternativas.terran.CentroDeMineral;
import razas.Terran;

public class CentroDeMineralTest {

	@Test
	public void testRecolectoMineral() {
		CentroDeMineral centro = new CentroDeMineral();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		centro.recolectarMineral(jugador.getRecursos());
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoMineral() {
		CentroDeMineral centro = new CentroDeMineral();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		centro.setDuenio(jugador);
		centro.pasarTurno();
		
		assertEquals(210 , jugador.getRecursos().obtenerMineral());
	}
}

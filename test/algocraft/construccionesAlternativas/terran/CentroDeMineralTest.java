package algocraft.construccionesAlternativas.terran;

import static org.junit.Assert.*;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import razasAlternativas.Terran;


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

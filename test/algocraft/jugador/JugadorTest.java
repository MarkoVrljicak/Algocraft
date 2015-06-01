package algocraft.jugador;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;

public class JugadorTest {
	private String nombreTerran = "Terran";

	@Test
	public void jugadorTerranEmpiezaConPoblacionCero() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(0, jugadorTerran.poblacion());
	}
	
	@Test
	public void jugadorObtieneNombreDeRaza() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(nombreTerran, jugadorTerran.getRaza());
	}
	
	@Test
	public void jugadorTerranTieneSeisConstruccionesDisponibles() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(6, jugadorTerran.getConstruccionesDisponibles().size());
	}
	

}

package algocraft.jugador;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;

public class JugadorTest {
	private String nombreTerran = "Terran";
	private String nombreBarraca = "Barraca";

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
	
	@Test
	public void jugadorTerranEmpiezaCon200DeMineral() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(200, jugadorTerran.getMineral());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon0DeGas() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(0, jugadorTerran.getGas());
	}
	
	@Test
	public void jugadorTerranEmpiezaSinEdificios() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(0, jugadorTerran.cantidadConstrucciones());
	}
	
	@Test
	public void jugadorTerranPuedeCrearBarracaConRecursosIniciales() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		jugadorTerran.construir(nombreBarraca);
		
		assertEquals(1, jugadorTerran.cantidadConstrucciones());
	}
	

}

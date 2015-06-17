package algocraft.jugador;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.exception.CondicionesInsuficientesException;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.EnumRazas;
import algocraft.razas.Terran;

public class JugadorTest {
	
	
	@Test
	public void jugadorTerranEmpiezaConPoblacionCero() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		
		assertEquals(0, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void jugadorObtieneNombreDeRaza() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);		
		assertEquals(EnumRazas.TERRAN, jugadorTerran.getRaza());
	}
	
	@Test
	public void jugadorTerranTieneSeisConstruccionesDisponibles() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		
		assertEquals(7, jugadorTerran.getConstruccionesDisponibles().size());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon200DeMineral() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		
		assertEquals(200, jugadorTerran.getMineral());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon0DeGas() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		
		assertEquals(0, jugadorTerran.getGas());
	}
	
	@Test
	public void jugadorTerranEmpiezaSinEdificios() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		
		assertEquals(0, jugadorTerran.cantidadConstrucciones());
	}
	
	@Test
	public void jugadorTerranPuedeCrearBarracaConRecursosIniciales() 
			throws CondicionesInsuficientesException {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		jugadorTerran.construir(EnumEdificiosTerran.BARRACA);
		
		assertEquals(1, jugadorTerran.cantidadConstrucciones());
	}
	
	@Test
	public void testJugadorEmpiezaConPoblacionMaximaCinco(){
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);		
		assertEquals(5,jugadorTerran.getPoblacionMaxima() );
	}
	
	
}

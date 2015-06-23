package modelo.jugador;

import static org.junit.Assert.assertEquals;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;

public class JugadorTest {
	
	
	@Test
	public void jugadorTerranEmpiezaConPoblacionCero() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		
		assertEquals(0, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void jugadorObtieneNombreDeRaza() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);		
		assertEquals(EnumRazas.TERRAN, jugadorTerran.getRaza());
	}
	
	@Test
	public void jugadorTerranTieneSeisConstruccionesDisponibles() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		
		assertEquals(7, jugadorTerran.getConstruccionesDisponibles().size());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon200DeMineral() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		
		assertEquals(200, jugadorTerran.getMineral());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon0DeGas() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		
		assertEquals(0, jugadorTerran.getGas());
	}
	
	@Test
	public void jugadorTerranEmpiezaSinEdificios() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		
		assertEquals(0, jugadorTerran.cantidadConstrucciones());
	}
	
	@Test
	public void jugadorTerranPuedeCrearBarracaConRecursosIniciales() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException, RecursosNegativosException {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		jugadorTerran.construir(EnumEdificiosTerran.BARRACA);
		
		assertEquals(1, jugadorTerran.cantidadConstrucciones());
	}
	
	@Test
	public void testJugadorEmpiezaConPoblacionMaximaCinco(){
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);		
		assertEquals(5,jugadorTerran.getPoblacionMaxima() );
	}
	
	
}

package modelo.jugador;

import static org.junit.Assert.*;
import modelo.jugador.JugadorNulo;

import org.junit.Test;

public class JugadorNuloTest {

	@Test
	public void testPedirRecursoAJugadorNuloDevuelveUnRecursoNoLimitante(){
		JugadorNulo jugadorNulo= new JugadorNulo();
		
		
		assertEquals(1000,jugadorNulo.getMineral() );
		assertEquals(1000,jugadorNulo.getGas() );
	}
	
	@Test
	public void testPedirPoblacionAJugadorNuloDevuelvePoblacionConEspacio5(){
		JugadorNulo jugadorNulo= new JugadorNulo();
		
		assertEquals(5, jugadorNulo.getPoblacionMaxima() );
	}
}

package algocraft.jugador;

import static org.junit.Assert.*;
import jugador.JugadorNulo;

import org.junit.Test;

import stats.Recurso;

public class JugadorNuloTest {

	@Test
	public void testPedirRecursoANullJugadorDevuelveUnRecursoVacio(){
		JugadorNulo jugadorNulo= new JugadorNulo();
		Recurso recursoObtenido=jugadorNulo.getRecursos();
		
		assertEquals(0,recursoObtenido.obtenerMineral() );
		assertEquals(0,recursoObtenido.obtenerGas() );
	}
}

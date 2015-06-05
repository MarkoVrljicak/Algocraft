package algocraft.jugador;

import static org.junit.Assert.*;
import jugador.JugadorNulo;

import org.junit.Test;

import stats.Poblacion;
import stats.Recurso;

public class JugadorNuloTest {

	@Test
	public void testPedirRecursoAJugadorNuloDevuelveUnRecursoNoLimitante(){
		JugadorNulo jugadorNulo= new JugadorNulo();
		Recurso recursoObtenido=jugadorNulo.getRecursos();
		
		assertEquals(1000,recursoObtenido.obtenerMineral() );
		assertEquals(1000,recursoObtenido.obtenerGas() );
	}
	
	@Test
	public void testPedirPoblacionAJugadorNuloDevuelvePoblacionConEspacio5(){
		JugadorNulo jugadorNulo= new JugadorNulo();
		Poblacion poblacion=jugadorNulo.getPoblacion();
		
		assertEquals(5, poblacion.maxima() );
	}
}

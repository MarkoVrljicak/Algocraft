package algocraft.razas;

import org.junit.Test;

import algocraft.exception.CondicionesInsuficientesException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;

public class RazaTest {

	@Test(expected = CondicionesInsuficientesException.class)
	public void testRazaLanzaExcepcionSiSeIntentaConstruirSinRecursosSuficientes() 
			throws RecursosNegativosException, CondicionesInsuficientesException {
		Protoss raza = new Protoss();
		Jugador jugador = new Jugador("Nombre", raza,  Colores.AZUL);
		
		raza.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		raza.crearConstruccion(EnumEdificiosProtos.ACCESO);
	}
}

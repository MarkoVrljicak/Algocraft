package modelo.razas;

import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.CreadorDeEdificiosProtoss;
import modelo.razas.EnumRazas;

import org.junit.Test;

public class CreadorEdificosTest {

	@Test(expected = MineralInsuficienteException.class)
	public void testRazaLanzaExcepcionSiSeIntentaConstruirSinRecursosSuficientes() 
			throws RecursosNegativosException, MineralInsuficienteException, 
			GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss raza = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		raza.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		raza.crearConstruccion(EnumEdificiosProtos.ACCESO);
	}
}

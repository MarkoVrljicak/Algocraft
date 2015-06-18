package algocraft.razas;

import org.junit.Test;

import algocraft.exception.DependenciasNoCumplidasException;
import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;

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

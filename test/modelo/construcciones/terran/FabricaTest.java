package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosTerran.CreadorFabrica;
import modelo.factory.unidadesTerran.CreadorGolliat;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class FabricaTest {
	

	private static final int tiempoConstruccionFabrica = 12;

	private CreadorDeUnidades crearFabricaValida() {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		for(int turnos = 1 ; turnos<= tiempoConstruccionFabrica ; turnos++)
			try {
				fabrica.iniciarTurno();
			} catch (PropiedadNoEstaEnJuegoException e) {
				// no entiendo por que se lanzaria esta excepcion
				e.printStackTrace();
			}
		return fabrica;
	}
	
	@Test
	public void testFabricaInicializaConGolliat() {
		CreadorDeUnidades fabrica = crearFabricaValida();
		
		assertEquals(true, fabrica.tengoUnidad(UnidadesTerran.GOLLIAT));
	}
		
	@Test
	public void testFabricaPuedeCrearGolliatConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades fabrica = crearFabricaValida();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(100);
		fabrica.setDuenio(jugador);
			
		assertEquals(true,fabrica.puedoCrearUnidad(new CreadorGolliat()));
	}	
		
	@Test
	public void testFabricaNoPuedeCrearGolliatConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades fabrica = crearFabricaValida();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		fabrica.setDuenio(jugador);
			
		assertEquals(false,fabrica.puedoCrearUnidad(new CreadorGolliat()));
	}
		
	@Test
	public void testFabricaCreaGolliat() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		
		CreadorDeUnidades fabrica = crearFabricaValida();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(100);
		fabrica.setDuenio(jugador);
		Unidad golliat = fabrica.crearUnidad(UnidadesTerran.GOLLIAT);
		
		assertEquals(UnidadesTerran.GOLLIAT, golliat.getNombre());
	}

}


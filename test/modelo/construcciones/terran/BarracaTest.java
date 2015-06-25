package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosTerran.CreadorBarraca;
import modelo.factory.unidadesTerran.CreadorMarine;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class BarracaTest {
	

	private static final int tiempoConstruccionBarraca = 12;

	private CreadorDeUnidades crearBarracaValida() {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		for(int turnos = 1 ; turnos<= tiempoConstruccionBarraca ; turnos++)
			try {
				barraca .iniciarTurno();
			} catch (PropiedadNoEstaEnJuegoException e) {
				// no entiendo por que se lanzaria esta excepcion
				e.printStackTrace();
			}
		return barraca;
	}

	@Test
	public void testBarracaInicializaConMarine() {
		CreadorDeUnidades barraca = crearBarracaValida();
		
		assertEquals(true, barraca.tengoUnidad(UnidadesTerran.MARINE));
	}
		
	@Test
	public void testBarracaPuedeCrearMarineConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades barraca = crearBarracaValida();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		barraca.setDuenio(jugador);
			
		assertEquals(true,barraca.puedoCrearUnidad(new CreadorMarine()));
	}	
		
	@Test
	public void testBarracaNoPuedeCrearMarineConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades barraca = crearBarracaValida();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		barraca.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,barraca.puedoCrearUnidad(new CreadorMarine()));
	}
		
	@Test
	public void testBarracaCreaMarine() 
			throws MineralInsuficienteException,GasInsuficienteException, PoblacionInsuficienteException, 
			RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		
		CreadorDeUnidades barraca = crearBarracaValida();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		barraca.setDuenio(jugador);
		Unidad marine = barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertEquals(UnidadesTerran.MARINE, marine.getNombre());
	}

}

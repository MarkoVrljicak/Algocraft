package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
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

	@Test
	public void testBarracaInicializaConMarine() {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		
		assertEquals(true, barraca.tengoUnidad(UnidadesTerran.MARINE));
	}
		
	@Test
	public void testBarracaPuedeCrearMarineConRecursosSuficientesyPoblacionSuficiente() {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		barraca.setDuenio(jugador);
			
		assertEquals(true,barraca.puedoCrearUnidad(new CreadorMarine()));
	}	
		
	@Test
	public void testBarracaNoPuedeCrearMarineConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		barraca.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,barraca.puedoCrearUnidad(new CreadorMarine()));
	}
		
	@Test
	public void testBarracaCreaMarine() 
			throws MineralInsuficienteException,GasInsuficienteException, PoblacionInsuficienteException, RecursosNegativosException {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		barraca.setDuenio(jugador);
		Unidad marine = barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertEquals(UnidadesTerran.MARINE, marine.getNombre());
	}
}

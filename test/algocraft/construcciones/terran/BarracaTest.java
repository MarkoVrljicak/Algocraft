package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosTerran.CreadorBarraca;
import algocraft.factory.unidadesTerran.CreadorMarine;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

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
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		barraca.setDuenio(jugador);
			
		assertEquals(true,barraca.puedoCrearUnidad(new CreadorMarine()));
	}	
		
	@Test
	public void testBarracaNoPuedeCrearMarineConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		barraca.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,barraca.puedoCrearUnidad(new CreadorMarine()));
	}
		
	@Test
	public void testBarracaCreaMarine() {
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		barraca.setDuenio(jugador);
		Unidad marine = barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertEquals(UnidadesTerran.MARINE, marine.getNombre());
	}
}

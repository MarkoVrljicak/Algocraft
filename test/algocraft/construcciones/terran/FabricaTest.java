package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.CondicionesInsuficientesException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosTerran.CreadorFabrica;
import algocraft.factory.unidadesTerran.CreadorGolliat;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

public class FabricaTest {
	
	@Test
	public void testFabricaInicializaConGolliat() {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		
		assertEquals(true, fabrica.tengoUnidad(UnidadesTerran.GOLLIAT));
	}
		
	@Test
	public void testFabricaPuedeCrearGolliatConRecursosSuficientesyPoblacionSuficiente() {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
			
		assertEquals(true,fabrica.puedoCrearUnidad(new CreadorGolliat()));
	}	
		
	@Test
	public void testFabricaNoPuedeCrearGolliatConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		fabrica.setDuenio(jugador);
			
		assertEquals(false,fabrica.puedoCrearUnidad(new CreadorGolliat()));
	}
		
	@Test
	public void testFabricaCreaGolliat() throws CondicionesInsuficientesException {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
		Unidad golliat = fabrica.crearUnidad(UnidadesTerran.GOLLIAT);
		
		assertEquals(UnidadesTerran.GOLLIAT, golliat.getNombre());
	}
}


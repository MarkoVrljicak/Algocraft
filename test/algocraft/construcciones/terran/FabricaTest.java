package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.terran.Fabrica;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

public class FabricaTest {
	
	private static final Recurso recursosNecesariosGolliat = new Recurso(100,50);
	private static final int poblacionNecesariaGolliat = 2;

	@Test
	public void testFabricaInicializaConGolliat() {
		Fabrica fabrica = new Fabrica();
		
		assertEquals(true, fabrica.tengoUnidad(UnidadesTerran.GOLLIAT));
	}
		
	@Test
	public void testFabricaPuedeCrearGolliatConRecursosSuficientesyPoblacionSuficiente() {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
			
		assertEquals(true,fabrica.puedoCrearUnidad(recursosNecesariosGolliat, poblacionNecesariaGolliat));
	}	
		
	@Test
	public void testFabricaNoPuedeCrearGolliatConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		fabrica.setDuenio(jugador);
			
		assertEquals(false,fabrica.puedoCrearUnidad(recursosNecesariosGolliat, poblacionNecesariaGolliat));
	}
		
	@Test
	public void testFabricaCreaGolliat() {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
		Unidad golliat = fabrica.crearUnidad(UnidadesTerran.GOLLIAT);
		
		assertEquals(UnidadesTerran.GOLLIAT, golliat.getNombre());
	}
}


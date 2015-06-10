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
	Colores colorAzul = Colores.AZUL;
	private static final UnidadesTerran nombreGolliat = UnidadesTerran.GOLLIAT;
	private static final Recurso recursosNecesariosGolliat = new Recurso(100,50);
	private static final int poblacionNecesariaGolliat = 2;

	@Test
	public void testFabricaInicializaConGolliat() {
		Fabrica fabrica = new Fabrica();
		
		assertEquals(true, fabrica.tengoUnidad(nombreGolliat));
	}
		
	@Test
	public void testFabricaPuedeCrearGolliatConRecursosSuficientesyPoblacionSuficiente() {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran(), colorAzul);
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
			
		assertEquals(true,fabrica.puedoCrearUnidad(recursosNecesariosGolliat, poblacionNecesariaGolliat));
	}	
		
	@Test
	public void testFabricaNoPuedeCrearGolliatConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran(), colorAzul);
		
		fabrica.setDuenio(jugador);
			
		assertEquals(false,fabrica.puedoCrearUnidad(recursosNecesariosGolliat, poblacionNecesariaGolliat));
	}
		
	@Test
	public void testFabricaCreaGolliat() {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran(), colorAzul);
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
		Unidad golliat = fabrica.crearUnidad(nombreGolliat);
		
		assertEquals(nombreGolliat, golliat.getNombre());
	}
}


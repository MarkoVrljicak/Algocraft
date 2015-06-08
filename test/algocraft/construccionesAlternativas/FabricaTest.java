package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;
import stats.Recurso;
import algocraft.construccionesAlternativas.terran.Fabrica;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.terran.UnidadesTerran;

public class FabricaTest {

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
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
			
		assertEquals(true,fabrica.puedoCrearUnidad(recursosNecesariosGolliat, poblacionNecesariaGolliat));
	}	
		
	@Test
	public void testFabricaNoPuedeCrearGolliatConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		fabrica.setDuenio(jugador);
			
		assertEquals(false,fabrica.puedoCrearUnidad(recursosNecesariosGolliat, poblacionNecesariaGolliat));
	}
		
	@Test
	public void testFabricaCreaGolliat() {
		Fabrica fabrica = new Fabrica();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		jugador.getRecursos().incrementarGas(100);
		fabrica.setDuenio(jugador);
		Unidad golliat = fabrica.crearUnidad(nombreGolliat);
		
		assertEquals(nombreGolliat, golliat.getNombre());
	}
}


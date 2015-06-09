package algocraft.construccionesAlternativas.terran;

import static org.junit.Assert.assertEquals;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import razasAlternativas.Terran;
import stats.Recurso;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.terran.UnidadesTerran;

public class BarracaTest {

	Colores color = Colores.AZUL;
	private static final UnidadesTerran nombreMarine = UnidadesTerran.MARINE;
	private static final Recurso recursosNecesariosMarine = new Recurso(50,0);
	private static final int poblacionNecesariaMarine = 1;

	@Test
	public void testBarracaInicializaConMarine() {
		Barraca barraca = new Barraca();
		
		assertEquals(true, barraca.tengoUnidad(nombreMarine));
	}
		
	@Test
	public void testBarracaPuedeCrearMarineConRecursosSuficientesyPoblacionSuficiente() {
		Barraca barraca = new Barraca();
		Jugador jugador = new Jugador("Nombre", new Terran(), color);
		barraca.setDuenio(jugador);
			
		assertEquals(true,barraca.puedoCrearUnidad(recursosNecesariosMarine, poblacionNecesariaMarine));
	}	
		
	@Test
	public void testBarracaNoPuedeCrearMarineConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Barraca barraca = new Barraca();
		Jugador jugador = new Jugador("Nombre", new Terran(), color);
		
		barraca.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,barraca.puedoCrearUnidad(recursosNecesariosMarine, poblacionNecesariaMarine));
	}
		
	@Test
	public void testBarracaCreaMarine() {
		Barraca barraca = new Barraca();
		Jugador jugador = new Jugador("Nombre", new Terran(), color);
		
		barraca.setDuenio(jugador);
		Unidad marine = barraca.crearUnidad(nombreMarine);
		
		assertEquals(nombreMarine, marine.getNombre());
	}
}

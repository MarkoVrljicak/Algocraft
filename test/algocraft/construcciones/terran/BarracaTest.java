package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.terran.Barraca;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

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

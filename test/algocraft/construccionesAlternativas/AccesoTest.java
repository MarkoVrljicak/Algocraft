package algocraft.construccionesAlternativas;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;
import stats.Recurso;
import algocraft.construccionesAlternativas.protos.Acceso;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.UnidadesProtos;

public class AccesoTest {
	
	private static final UnidadesProtos nombreZealot= UnidadesProtos.ZEALOT;
	private static final Recurso recursosNecesariosZealot = new Recurso(100,0);
	private static final int poblacionNecesariaZealot = 2;
	
	@Test
	public void testAccesoInicializaConZealot() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(nombreZealot));
	}
		
	@Test
	public void testAccesoPuedeCrearZealotConRecursosSuficientesyPoblacionSuficiente() {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Terran());
		acceso.setDuenio(jugador);
			
		assertEquals(true,acceso.puedoCrearUnidad(recursosNecesariosZealot, poblacionNecesariaZealot));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearZealotConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		acceso.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(recursosNecesariosZealot, poblacionNecesariaZealot));
	}
		
	@Test
	public void testAccesoCreaZealot() {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		acceso.setDuenio(jugador);
		Unidad zealot = acceso.crearUnidad(nombreZealot);
		
		assertEquals(nombreZealot, zealot.getNombre());
	}
}


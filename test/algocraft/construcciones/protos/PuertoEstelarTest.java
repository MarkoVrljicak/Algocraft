package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.PuertoEstelar;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.UnidadesProtos;

public class PuertoEstelarTest {
	Colores colorAzul = Colores.AZUL;
	private static final UnidadesProtos nombreScout= UnidadesProtos.SCOUT;
	private static final UnidadesProtos nombreNaveDeTransporte= UnidadesProtos.NAVE_DE_TRANSPORTE;
	private static final Recurso recursosNecesariosScout = new Recurso(300,150);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(200,0);
	private static final int poblacionNecesariaScout = 3;
	private static final int poblacionNecesariaNaveDeTransporte = 2;
	
	@Test
	public void testPuertoEstelarInicializaConScout() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreScout));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearScoutConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		jugador.getRecursos().incrementarMineral(100);
		jugador.getRecursos().incrementarGas(150);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosScout, poblacionNecesariaScout));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearScoutConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosScout, poblacionNecesariaScout));
	}
		
	@Test
	public void testPuertoEstelarCreaScout() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);		
		jugador.getRecursos().incrementarMineral(100);
		jugador.getRecursos().incrementarGas(150);
		puertoEstelar.setDuenio(jugador);
		Unidad scout = puertoEstelar.crearUnidad(nombreScout);
		
		assertEquals(nombreScout, scout.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreNaveDeTransporte));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		puertoEstelar.setDuenio(jugador);
					
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), colorAzul);		
		jugador.getRecursos().incrementarGas(50);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(nombreNaveDeTransporte);
		
		assertEquals(nombreNaveDeTransporte, nave.getNombre());
	}
}


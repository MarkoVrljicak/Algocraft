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
	
	private static final Recurso recursosNecesariosScout = new Recurso(300,150);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(200,0);
	private static final int poblacionNecesariaScout = 3;
	private static final int poblacionNecesariaNaveDeTransporte = 2;
	
	@Test
	public void testPuertoEstelarInicializaConScout() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesProtos.SCOUT));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearScoutConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarMineral(100);
		jugador.getRecursos().incrementarGas(150);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosScout, poblacionNecesariaScout));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearScoutConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosScout, poblacionNecesariaScout));
	}
		
	@Test
	public void testPuertoEstelarCreaScout() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);		
		jugador.getRecursos().incrementarMineral(100);
		jugador.getRecursos().incrementarGas(150);
		puertoEstelar.setDuenio(jugador);
		Unidad scout = puertoEstelar.crearUnidad(UnidadesProtos.SCOUT);
		
		assertEquals(UnidadesProtos.SCOUT, scout.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesProtos.NAVE_DE_TRANSPORTE));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
					
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);		
		jugador.getRecursos().incrementarGas(50);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesProtos.NAVE_DE_TRANSPORTE);
		
		assertEquals(UnidadesProtos.NAVE_DE_TRANSPORTE, nave.getNombre());
	}
}


package algocraft.construccionesAlternativas;

import static org.junit.Assert.*;
import jugador.Jugador;

import org.junit.Test;

import razas.Terran;
import stats.Recurso;
import algocraft.construccionesAlternativas.terran.PuertoEstelar;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.UnidadesTerran;

public class PuertoEstelarTest {

	private static final UnidadesTerran nombreEspectro = UnidadesTerran.ESPECTRO;
	private static final UnidadesTerran nombreNaveDeTransporte = UnidadesTerran.NAVE_TRANSPORTE;
	private static final UnidadesTerran nombreNaveDeCiencia = UnidadesTerran.NAVE_CIENCIA;
	private static final Recurso recursosNecesariosEspectro = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeCiencia = new Recurso(50,0);
	private static final int poblacionNecesariaEspectro = 1;
	private static final int poblacionNecesariaNaveDeTransporte = 1;
	private static final int poblacionNecesariaNaveDeCiencia = 1;
	
	@Test
	public void testPuertoEstelarInicializaConEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreEspectro));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearEspectroConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosEspectro, poblacionNecesariaEspectro));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearEspectroConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosEspectro, poblacionNecesariaEspectro));
	}
		
	@Test
	public void testPuertoEstelarCreaEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
		Unidad espectro = puertoEstelar.crearUnidad(nombreEspectro);
		
		assertEquals(nombreEspectro, espectro.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreNaveDeTransporte));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(nombreNaveDeTransporte);
		
		assertEquals(nombreNaveDeTransporte, nave.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreNaveDeCiencia));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeCienciaConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeCienciaConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran());
		
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(nombreNaveDeCiencia);
		
		assertEquals(nombreNaveDeCiencia, nave.getNombre());
	}
}

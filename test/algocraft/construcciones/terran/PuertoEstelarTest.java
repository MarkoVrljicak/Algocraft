package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.terran.PuertoEstelar;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

public class PuertoEstelarTest {
	
	private static final Recurso recursosNecesariosEspectro = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeTransporte = new Recurso(50,0);
	private static final Recurso recursosNecesariosNaveDeCiencia = new Recurso(50,0);
	private static final int poblacionNecesariaEspectro = 1;
	private static final int poblacionNecesariaNaveDeTransporte = 1;
	private static final int poblacionNecesariaNaveDeCiencia = 1;
	
	@Test
	public void testPuertoEstelarInicializaConEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.ESPECTRO));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearEspectroConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosEspectro, poblacionNecesariaEspectro));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearEspectroConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosEspectro, poblacionNecesariaEspectro));
	}
		
	@Test
	public void testPuertoEstelarCreaEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);		
		puertoEstelar.setDuenio(jugador);
		
		Unidad espectro = puertoEstelar.crearUnidad(UnidadesTerran.ESPECTRO);
		
		assertEquals(UnidadesTerran.ESPECTRO, espectro.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.NAVE_TRANSPORTE));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeTransporte, poblacionNecesariaNaveDeTransporte));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesTerran.NAVE_TRANSPORTE);
		
		assertEquals(UnidadesTerran.NAVE_TRANSPORTE, nave.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.NAVE_CIENCIA));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeCienciaConRecursosSuficientesyPoblacionSuficiente() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeCienciaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(recursosNecesariosNaveDeCiencia, poblacionNecesariaNaveDeCiencia));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesTerran.NAVE_CIENCIA);
		
		assertEquals(UnidadesTerran.NAVE_CIENCIA, nave.getNombre());
	}
}

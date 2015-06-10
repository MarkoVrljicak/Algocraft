package razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.construcciones.terran.EnumEdificiosTerran;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.stats.Recurso;

public class TerranTest {
	Colores colorAzul = Colores.AZUL;
	private static final EnumEdificiosTerran nombreBarraca= EnumEdificiosTerran.BARRACA;
	private static final EnumEdificiosTerran nombreCentroDeMineral= EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreDepositoDeSuministros= EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS;
	private static final EnumEdificiosTerran nombreFabrica= EnumEdificiosTerran.FABRICA;
	private static final EnumEdificiosTerran nombrePuertoEstelar= EnumEdificiosTerran.PUERTO_ESTELAR;
	private static final EnumEdificiosTerran nombreRefineria= EnumEdificiosTerran.REFINERIA;
	private static final EnumEdificiosProtos nombreNexoMineral= EnumEdificiosProtos.NEXO_MINERAL;
	private static final Recurso recursosNecesariosBarraca = new Recurso(150,0);
	private static final Recurso recursosNecesariosCentroDeMineral = new Recurso(50,0);
	private static final Recurso recursosNecesariosDepositoDeSuministros = new Recurso(100,0);
	private static final Recurso recursosNecesariosFabrica = new Recurso(200,100);
	private static final Recurso recursosNecesariosPuertoEstelar = new Recurso(150,100);
	private static final Recurso recursosNecesariosRefineria = new Recurso(100,0);
	
	@Test
	public void testTerranInicializaConCentroMineral() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(nombreCentroDeMineral));
	}
	
	@Test
	public void testTerranInicializaConBarraca() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(nombreBarraca));
	}
	
	@Test
	public void testTerranInicializaConDepositoDeSuministros() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(nombreDepositoDeSuministros));
	}
	
	@Test
	public void testTerranInicializaConRefineria() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(nombreRefineria));
	}
	
	@Test
	public void testTerrranInicializaConFabrica() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(nombreFabrica));
	}
	
	@Test
	public void testTerranInicializaConPuertoEstelar() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(nombrePuertoEstelar));
	}
	
	@Test
	public void testTerranNoTieneNexoMineral() {
		Terran terran = new Terran();
		
		assertEquals(false, terran.tengoConstruccion(nombreNexoMineral));
	}
	
	@Test
	public void testTerranPuedeCrearBarracaConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(recursosNecesariosBarraca));
	}	
		
	@Test
	public void testTerranNoPuedeCrearBarracaConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(recursosNecesariosBarraca));
	}
		
	@Test
	public void testTerranCreaBarraca() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		Construccion barraca = terran.crearConstruccion(nombreBarraca);
		
		assertEquals(nombreBarraca, barraca.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearCentroDeMineralConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(recursosNecesariosCentroDeMineral));
	}	
		
	@Test
	public void testTerranNoPuedeCrearCentroDeMineralConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(recursosNecesariosCentroDeMineral));
	}
		
	@Test
	public void testTerranCreaCentroDeMineral() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		Construccion centroDeMineral = terran.crearConstruccion(nombreCentroDeMineral);
		
		assertEquals(nombreCentroDeMineral, centroDeMineral.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearDepositoDeSuministrosConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(recursosNecesariosDepositoDeSuministros));
	}	
		
	@Test
	public void testTerranNoPuedeCrearDepositoDeSuministrosConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(recursosNecesariosDepositoDeSuministros));
	}
		
	@Test
	public void testTerranCreaDepositoDeSuministros() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		Construccion depositoDeSuministros = terran.crearConstruccion(nombreDepositoDeSuministros);
		
		assertEquals(nombreDepositoDeSuministros, depositoDeSuministros.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearFabricaConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		jugador.getRecursos().incrementarGas(100);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(recursosNecesariosFabrica));
	}	
		
	@Test
	public void testTerranNoPuedeCrearFabricaConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(recursosNecesariosFabrica));
	}
		
	@Test
	public void testTerranPuedeCrearPuertoEstelarConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		jugador.getRecursos().incrementarGas(100);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(recursosNecesariosPuertoEstelar));
	}	
		
	@Test
	public void testTerranNoPuedeCrearPuertoEstelarConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(recursosNecesariosPuertoEstelar));
	}
		
	@Test
	public void testTerranPuedeCrearRefineriaConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(recursosNecesariosRefineria));
	}	
		
	@Test
	public void testTerranNoPuedeCrearRefineriaConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(recursosNecesariosRefineria));
	}
		
	@Test
	public void testTerranCreaRefineria() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, colorAzul);
		
		terran.setDuenio(jugador);
		Construccion refineria = terran.crearConstruccion(nombreRefineria);
		
		assertEquals(nombreRefineria, refineria.getNombre());
	}

	@Test
	public void testTerranEmpiezaConSieteConstruccionesDisponibles(){
		Terran terran = new Terran();
		
		assertEquals(7, terran.getListaDeConstrucciones().size());
	}

}

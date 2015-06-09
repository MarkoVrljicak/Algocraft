package razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import razasAlternativas.Terran;

public class TerranTest {
	private static final EnumEdificiosTerran nombreBarraca= EnumEdificiosTerran.BARRACA;
	private static final EnumEdificiosTerran nombreCentroDeMineral= EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreDepositoDeSuministros= EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS;
	private static final EnumEdificiosTerran nombreFabrica= EnumEdificiosTerran.FABRICA;
	private static final EnumEdificiosTerran nombrePuertoEstelar= EnumEdificiosTerran.PUERTO_ESTELAR;
	private static final EnumEdificiosTerran nombreRefineria= EnumEdificiosTerran.REFINERIA;
	private static final EnumEdificiosProtos nombreNexoMineral= EnumEdificiosProtos.NEXO_MINERAL;

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
	/*se van a tests de integracion
	@Test
	public void testTerranCreaCentroDeMineral() {
		Terran terran = new Terran();
		Construccion centroDeMineral = terran.construirConstruccion(muchosRecursos, nombreCentroDeMineral);
		
		assertEquals(nombreCentroDeMineral, centroDeMineral.getNombre());
	}
	
	@Test
	public void testTerranCreaBarraca() {
		Terran terran = new Terran();
		Construccion barraca = terran.construirConstruccion(muchosRecursos, nombreBarraca);
		
		assertEquals(nombreBarraca, barraca.getNombre());
	}
	
	@Test
	public void testTerranCreaDepositoDeSuministros() {
		Terran terran = new Terran();
		Construccion deposito = terran.construirConstruccion(muchosRecursos, nombreDepositoDeSuministros);
		
		assertEquals(nombreDepositoDeSuministros, deposito.getNombre());
	}
	
	@Test
	public void testTerranCreaDepositoRefineria() {
		Terran terran = new Terran();
		Construccion refineria = terran.construirConstruccion(muchosRecursos, nombreRefineria);
		
		assertEquals(nombreRefineria, refineria.getNombre());
	}
	
	@Test
	public void testTerranCreaFabrica() {
		Terran terran = new Terran();
		Construccion fabrica = terran.construirConstruccion(muchosRecursos, nombreFabrica);
		
		assertEquals(nombreFabrica, fabrica.getNombre());
	}
	
	@Test
	public void testTerranCreaPuertoEstelar() {
		Terran terran = new Terran();
		Construccion puerto = terran.construirConstruccion(muchosRecursos, nombrePuertoEstelar);
		
		assertEquals(nombrePuertoEstelar, puerto.getNombre());
	}
	
	@Test
	public void testTerranNoCreaNexoMineral() {
		Terran terran = new Terran();
		Construccion nexo = terran.construirConstruccion(muchosRecursos, "Nexo Mineral");
		
		assertEquals(null, nexo);
	}
	
	@Test
	public void testTerranNoCreaCentroDeMineralSinRecursos() {
		Terran terran = new Terran();
		Construccion nexo = terran.construirConstruccion(sinRecursos, nombreCentroDeMineral);
		
		assertEquals(null, nexo);
	}
	*/
	@Test
	public void testTerranEmpiezaConSieteConstruccionesDisponibles(){
		Terran terran = new Terran();
		
		assertEquals(7, terran.getListaDeConstrucciones().size());
	}

}

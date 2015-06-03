package razas;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;

public class TerranTest {
	private Recurso sinRecursos = new Recurso(0,0);
	private Recurso muchosRecursos = new Recurso(999,999);
	public String nombreFabrica = "Fabrica";
	public String nombreCentroDeMineral = "Centro De Mineral";
	public String nombreBarraca = "Barraca";
	public String nombreDepositoDeSuministros = "Deposito De Suministros";
	public String nombreRefineria = "Refineria";
	public String nombrePuertoEstelar = "Puerto Estelar";

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
		
		assertEquals(false, terran.tengoConstruccion("Nexo Mineral"));
	}
	
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
	
	@Test
	public void testTerranEmpiezaConSeisConstruccionesDisponibles(){
		Terran terran = new Terran();
		
		assertEquals(6, terran.getListaDeConstrucciones().size());
	}

}

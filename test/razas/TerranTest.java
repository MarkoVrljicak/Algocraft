package razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;

public class TerranTest {
	private int sinMineral = 0;
	private int sinGas = 0;
	private int muchoMineral = 999;
	private int muchoGas = 999;
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
		Construccion centroDeMineral = terran.construirConstruccion(muchoMineral, muchoGas, nombreCentroDeMineral);
		
		assertEquals(nombreCentroDeMineral, centroDeMineral.getNombre());
	}
	
	@Test
	public void testTerranCreaBarraca() {
		Terran terran = new Terran();
		Construccion barraca = terran.construirConstruccion(muchoMineral, muchoGas, nombreBarraca);
		
		assertEquals(nombreBarraca, barraca.getNombre());
	}
	
	@Test
	public void testTerranCreaDepositoDeSuministros() {
		Terran terran = new Terran();
		Construccion deposito = terran.construirConstruccion(muchoMineral, muchoGas, nombreDepositoDeSuministros);
		
		assertEquals(nombreDepositoDeSuministros, deposito.getNombre());
	}
	
	@Test
	public void testTerranCreaDepositoRefineria() {
		Terran terran = new Terran();
		Construccion refineria = terran.construirConstruccion(muchoMineral, muchoGas, nombreRefineria);
		
		assertEquals(nombreRefineria, refineria.getNombre());
	}
	
	@Test
	public void testTerranCreaFabrica() {
		Terran terran = new Terran();
		Construccion fabrica = terran.construirConstruccion(muchoMineral, muchoGas, nombreFabrica);
		
		assertEquals(nombreFabrica, fabrica.getNombre());
	}
	
	@Test
	public void testTerranCreaPuertoEstelar() {
		Terran terran = new Terran();
		Construccion puerto = terran.construirConstruccion(muchoMineral, muchoGas, nombrePuertoEstelar);
		
		assertEquals(nombrePuertoEstelar, puerto.getNombre());
	}
	
	@Test
	public void testTerranNoCreaNexoMineral() {
		Terran terran = new Terran();
		Construccion nexo = terran.construirConstruccion(muchoMineral, muchoGas, "Nexo Mineral");
		
		assertEquals(null, nexo);
	}
	
	@Test
	public void testTerranNoCreaCentroDeMineralSinRecursos() {
		Terran terran = new Terran();
		Construccion nexo = terran.construirConstruccion(sinMineral, sinGas, nombreCentroDeMineral);
		
		assertEquals(null, nexo);
	}
	
	@Test
	public void testTerranEmpiezaConSeisConstruccionesDisponibles(){
		Terran terran = new Terran();
		
		assertEquals(6, terran.getListaDeConstrucciones().size());
	}

}

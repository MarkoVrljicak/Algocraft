package razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;

public class TerranTest {
	private int muchoMineral = 999;
	private int muchoGas = 999;

	@Test
	public void testBarracaInicializaConCentroMineral() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion("Centro De Mineral"));
	}
	
	@Test
	public void testBarracaInicializaConBarraca() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion("Barraca"));
	}
	
	@Test
	public void testBarracaInicializaConDepositoDeSuministros() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion("Deposito De Suministros"));
	}
	
	@Test
	public void testBarracaInicializaConRefineria() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion("Refineria"));
	}
	
	@Test
	public void testBarracaInicializaConFabrica() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion("Fabrica"));
	}
	
	@Test
	public void testBarracaInicializaConPuertoEstelar() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion("Puerto Estelar"));
	}
	
	@Test
	public void testTerranCreaCentroDeMineral() {
		Terran terran = new Terran();
		Construccion centroDeMineral = terran.construirConstruccion(muchoMineral, muchoGas, "Centro De Mineral");
		
		assertEquals("Centro De Mineral", centroDeMineral.getNombre());
	}
	
	@Test
	public void testTerranCreaBarraca() {
		Terran terran = new Terran();
		Construccion barraca = terran.construirConstruccion(muchoMineral, muchoGas, "Barraca");
		
		assertEquals("Barraca", barraca.getNombre());
	}
	
	@Test
	public void testTerranCreaDepositoDeSuministros() {
		Terran terran = new Terran();
		Construccion deposito = terran.construirConstruccion(muchoMineral, muchoGas, "Deposito De Suministros");
		
		assertEquals("Deposito De Suministros", deposito.getNombre());
	}
	
	@Test
	public void testTerranCreaDepositoRefineria() {
		Terran terran = new Terran();
		Construccion refineria = terran.construirConstruccion(muchoMineral, muchoGas, "Refineria");
		
		assertEquals("Refineria", refineria.getNombre());
	}

}

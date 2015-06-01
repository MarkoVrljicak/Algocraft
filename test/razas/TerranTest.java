package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerranTest {

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

}

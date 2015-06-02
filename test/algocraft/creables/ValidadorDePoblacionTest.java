package algocraft.creables;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;
import algocraft.unidades.terran.Marine;

public class ValidadorDePoblacionTest {
	
	public int poblacionDeMas=100;
	public int poblacionSuficiente=1;
	public int sinPoblacion=0;
	private Recurso suficientesRecursos= new Recurso(1000,1000);

	@Test
	public void testPuedeCrearCreableConPoblacionSuficiente() {
		Marine marineAGuardar = new Marine();
		ValidadorDePoblacion proxy = new ValidadorDePoblacion( suficientesRecursos, marineAGuardar,1);
		
		assertEquals( marineAGuardar.getNombre(), proxy.crear(suficientesRecursos,poblacionSuficiente).getNombre());
	}
	
	@Test
	public void testPuedeCrearCreableConPoblacionDeMas() {
		Marine marineAGuardar = new Marine();
		ValidadorDePoblacion proxy = new ValidadorDePoblacion( suficientesRecursos, marineAGuardar,1);
		
		assertEquals( marineAGuardar.getNombre(), proxy.crear(suficientesRecursos,poblacionDeMas).getNombre());
	}
	
	@Test
	public void testNoPuedeCrearCreableSinPoblacion() {
		Marine marineAGuardar = new Marine();
		ValidadorDePoblacion proxy = new ValidadorDePoblacion( suficientesRecursos, marineAGuardar,1);
		
		assertEquals(null, proxy.crear(suficientesRecursos,sinPoblacion));
	}
}

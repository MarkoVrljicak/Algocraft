package algocraft.creables;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Fabrica;

public class ValidadorDeCreacionesTest {
	/* Estos no son los requerimientos de la Fabrica, pero uso estos para los test */
	public Recurso sinRecursos= new Recurso(0,0);
	public Recurso suficientesRecursos= new Recurso(100,100);
	public Recurso extraRecursos= new Recurso(101,101);
	public Recurso recursosConGasSinMineral= new Recurso(0,100);
	public Recurso recursosConMineralSinGas= new Recurso(100,0);
		
	@Test
	public void testObtengoNombreDelCreableGuardado() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( sinRecursos, fabrica);
		
		assertEquals("Fabrica", proxy.getNombreCreable());
	}
	
	@Test
	public void testPuedeCrearCreableConRecursosDeMas() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficientesRecursos, fabricaAGuardar);
		
		assertEquals(fabricaAGuardar.getNombre(), proxy.crear(extraRecursos).getNombre());
	}
	
	@Test
	public void testPuedeCrearCreableConRecursosSuficientes() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficientesRecursos, fabricaAGuardar);
		
		assertEquals(fabricaAGuardar.getNombre(), proxy.crear(suficientesRecursos).getNombre());
	}
	
	@Test
	public void testNoPuedeCrearCreableConRecursosInsuficientes() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficientesRecursos, fabricaAGuardar);
		
		assertEquals(null, proxy.crear(sinRecursos));
	}
	
	@Test
	public void testNoPuedeCrearCreableConMineralInsuficienteYGasSuficiente() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficientesRecursos, fabricaAGuardar);
		
		assertEquals(null, proxy.crear(recursosConGasSinMineral));
	}
	
	@Test
	public void testNoPuedeCrearCreableConGasInsuficienteYMineralSuficiente() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficientesRecursos, fabricaAGuardar);
		
		assertEquals(null, proxy.crear(recursosConMineralSinGas));
	}


}

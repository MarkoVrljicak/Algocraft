package algocraft.creables;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.ValidadorDeCreaciones;
import algocraft.construcciones.Fabrica;

public class ValidadorDeCreacionesTest {
	/* Estos no son los requerimientos de la Fabrica, pero uso estos para los test */
	public int sinGas = 0;
	public int suficienteGas = 100;
	public int demasiadoGas = 101;
	public int sinMineral = 0;
	public int suficienteMineral = 100;
	public int demasiadoMineral = 101;
	
	@Test
	public void testObtengoNombreDelCreableGuardado() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( sinMineral, sinGas, fabrica);
		
		assertEquals("Fabrica", proxy.getNombreCreable());
	}
	
	@Test
	public void testPuedeCrearCreableConRecursosDeMas() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabricaAGuardar);
		
		assertEquals(fabricaAGuardar.getNombre(), proxy.crear(demasiadoMineral, demasiadoGas).getNombre());
	}
	
	@Test
	public void testPuedeCrearCreableConRecursosSuficientes() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabricaAGuardar);
		
		assertEquals(fabricaAGuardar.getNombre(), proxy.crear(suficienteMineral, suficienteGas).getNombre());
	}
	
	@Test
	public void testNoPuedeCrearCreableConRecursosInsuficientes() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabricaAGuardar);
		
		assertEquals(null, proxy.crear(sinMineral, sinGas));
	}
	
	@Test
	public void testNoPuedeCrearCreableConMineralInsuficienteYGasSuficiente() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabricaAGuardar);
		
		assertEquals(null, proxy.crear(sinMineral, suficienteGas));
	}
	
	@Test
	public void testNoPuedeCrearCreableConGasInsuficienteYMineralSuficiente() {
		Fabrica fabricaAGuardar = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabricaAGuardar);
		
		assertEquals(null, proxy.crear(suficienteMineral, sinGas));
	}


}

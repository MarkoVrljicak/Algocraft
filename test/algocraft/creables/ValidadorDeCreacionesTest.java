package algocraft.creables;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.ValidadorDeCreaciones;
import algocraft.construcciones.Fabrica;

public class ValidadorDeCreacionesTest {
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
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabrica);
		
		assertEquals(true, proxy.puedoCrearme(demasiadoMineral, demasiadoGas));
	}
	
	@Test
	public void testPuedeCrearCreableConRecursosSuficientes() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabrica);
		
		assertEquals(true, proxy.puedoCrearme(suficienteMineral, suficienteGas));
	}
	
	@Test
	public void testNoPuedeCrearCreableConRecursosInsuficientes() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabrica);
		
		assertEquals(false, proxy.puedoCrearme(sinMineral, sinGas));
	}
	
	@Test
	public void testNoPuedeCrearCreableConMineralInsuficiente() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabrica);
		
		assertEquals(false, proxy.puedoCrearme(sinMineral, suficienteGas));
	}
	
	@Test
	public void testNoPuedeCrearCreableConGasInsuficiente() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( suficienteMineral, suficienteGas, fabrica);
		
		assertEquals(false, proxy.puedoCrearme(suficienteMineral, sinGas));
	}


}

package algocraft.stats;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.exception.RecursosNegativosException;
import algocraft.stats.Recurso;

public class RecursoTest {

	@Test
	public void testCreoRecursoYObtengoMineral(){
		Recurso recurso= new Recurso(100,0);
		
		assertEquals(100,recurso.obtenerMineral());
	}
	
	@Test
	public void testCreoRecursoYObtengoGas(){
		Recurso recurso= new Recurso(0,100);
		
		assertEquals(100,recurso.obtenerGas());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreoRecursoMineralesNegativosLanzaException(){
		
		new Recurso(-1,0);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreoRecursoGasNegativoLanzaException(){
		
		new Recurso(0,-1);
		
	} 
	
	@Test
	public void testIncrementoMineralVerifico(){
		Recurso recursosDisponibles = new Recurso(100,100);
		int mineralAIncrementar = 50;
		
		recursosDisponibles.incrementarMineral(mineralAIncrementar);
			
		assertEquals(150, recursosDisponibles.obtenerMineral());
	}
	
	@Test
	public void testIncrementoGasVerifico(){
		Recurso recursosDisponibles = new Recurso(100,100);
		int gasAIncrementar = 50;
		
		recursosDisponibles.incrementarGas(gasAIncrementar);
			
		assertEquals(150, recursosDisponibles.obtenerGas());
	}
	
	@Test
	public void testConsumoMineralVerifico() throws RecursosNegativosException{
		Recurso recursosDisponibles = new Recurso(100,100);
		int mineralAConsumir = 50;
		
		recursosDisponibles.consumirMineral(mineralAConsumir);
			
		assertEquals(50, recursosDisponibles.obtenerMineral());
	}
	
	@Test
	public void testConsumoGasVerifico() throws RecursosNegativosException{
		Recurso recursosDisponibles = new Recurso(100,100);
		int gasAConsumir = 50;
		
		recursosDisponibles.consumirGas(gasAConsumir);
			
		assertEquals(50, recursosDisponibles.obtenerGas());
	}
	
	@Test(expected = RecursosNegativosException.class)
	public void testConsumoMineralDeMasLanzaExcepcion() throws RecursosNegativosException{
		Recurso recursosDisponibles = new Recurso(100,100);
		int mineralAConsumir = 101;
		
		recursosDisponibles.consumirMineral(mineralAConsumir);
	}
	
	@Test(expected = RecursosNegativosException.class)
	public void testConsumoGasDeMasLanzaExcepcion() throws RecursosNegativosException{
		Recurso recursosDisponibles = new Recurso(100,100);
		int gasAConsumir = 101;
		
		recursosDisponibles.consumirGas(gasAConsumir);
	}
}

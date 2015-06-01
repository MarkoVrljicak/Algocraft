package stats;

import static org.junit.Assert.*;

import org.junit.Test;

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
}

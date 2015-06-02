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
	
	@Test
	public void testRecursoDisminuyeMineralDelOtro(){
		Recurso recursosDisponibles = new Recurso(100,100);
		Recurso recursosNecesarios = new Recurso(50,50);
		recursosDisponibles.gastarRecurso(recursosNecesarios);
		
		assertEquals(50, recursosDisponibles.obtenerMineral());
	}
	
	@Test
	public void testRecursoDisminuyeGaslDelOtro(){
		Recurso recursosDisponibles = new Recurso(100,100);
		Recurso recursosNecesarios = new Recurso(50,50);
		recursosDisponibles.gastarRecurso(recursosNecesarios);
		
		assertEquals(50, recursosDisponibles.obtenerGas());
	}
}

package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoblacionTest {

	@Test
	public void testPoblacionMaximaEmpiezaEn5(){
		Poblacion poblacion= new Poblacion();
			
		assertEquals(5,poblacion.maxima());
	}
		
	@Test
	public void testIncrementoPoblacionMaximaVerifico(){
		Poblacion poblacion= new Poblacion();
			
		poblacion.incrementarMaxima(5);
			
		assertEquals(10,poblacion.maxima());
	}
	
	@Test
	public void testIncrementoPoblacionActualVerifico(){
		Poblacion poblacion= new Poblacion();
			
		poblacion.incrementarActual(5);
			
		assertEquals(5,poblacion.actual());
	}
		
	@Test
	public void testPoblacionDisponibleEsMaximaMenosActual(){
		Poblacion poblacion= new Poblacion();
		
		poblacion.incrementarActual(3);
					
		assertEquals(2,poblacion.disponible());
	}
	
	@Test
	public void testVerificoSiPoblacionMaximaSupera200Devuelve200(){
		Poblacion poblacion= new Poblacion();
		
		poblacion.incrementarMaxima(205);
		
		assertEquals(200,poblacion.maxima());
	}
	
}

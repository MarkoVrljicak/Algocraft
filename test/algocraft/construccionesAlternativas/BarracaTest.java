package algocraft.construccionesAlternativas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;


public class BarracaTest {

	private static final Unidades nombreMarine = Unidades.MARINE;
	private static final Recurso  muchosRecursos= new Recurso(999,999);
	private static final int poblacionSuficiente=5;
	private static final Recurso  recursosInsuficientes= new Recurso(0,0);
	private static final int poblacionInsuficiente=0;
	private static final Recurso  recursosJustos= new Recurso(50,0);
	private static final int poblacionJusta=1;

		@Test
	public void testBarracaInicializaConMarine() {
		Barraca barraca = new Barraca();
		
		assertEquals(true, barraca.tengoUnidad(nombreMarine));
	}
		
	@Test
	public void testBarracaPuedeCrearMarineConRecursosSuficientesyPoblacionSuficiente() {
		Barraca barraca = new Barraca();
			
		assertEquals(true,barraca.puedoCrearUnidad(nombreMarine, muchosRecursos, poblacionSuficiente));
	}	
	
	@Test
	public void testBarracaPuedeCrearMarineConRecursosJustosyPoblacionJusta() {
		Barraca barraca = new Barraca();
			
		assertEquals(true,barraca.puedoCrearUnidad(nombreMarine, recursosJustos, poblacionJusta));
	}
	
	@Test
	public void testBarracaNoPuedeCrearMarineConRecursosInSuficientesyPoblacionSuficiente() {
		Barraca barraca = new Barraca();
			
		assertEquals(false,barraca.puedoCrearUnidad(nombreMarine, recursosInsuficientes, poblacionSuficiente));
	}
	
	@Test
	public void testBarracaNoPuedeCrearMarineConRecursosSuficientesyPoblacionInSuficiente() {
		Barraca barraca = new Barraca();
			
		assertEquals(false,barraca.puedoCrearUnidad(nombreMarine, muchosRecursos, poblacionInsuficiente));
	}
	
	@Test
	public void testBarracaCreaMarine() {
		Barraca barraca = new Barraca();
		Unidad marine = barraca.crearUnidad(nombreMarine, muchosRecursos, poblacionSuficiente);
		
		assertEquals(nombreMarine, marine.getNombre());
	}
}

package algocraft.unidades.Alternativas;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnidadBasicaTest {
	

	private static final int vidaMarine = 40;
	private static final UnidadesTerran nombreMarine = UnidadesTerran.MARINE;

	@Test
	public void testCreoUnidadVerificoVida(){
		Unidad marine= new Unidad(nombreMarine,vidaMarine);
		
		assertEquals(vidaMarine,marine.getVida());
	}
	
	@Test
	public void testCreoUnidadVerificoNombre(){
		Unidad marine= new Unidad(nombreMarine,vidaMarine);
		
		assertEquals(nombreMarine,marine.getNombre());
	}
}

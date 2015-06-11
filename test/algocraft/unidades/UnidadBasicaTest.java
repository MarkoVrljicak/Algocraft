package algocraft.unidades;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.UnidadesTerran;

public class UnidadBasicaTest {
	

	private static final int vidaMarine = 40;

	@Test
	public void testCreoUnidadVerificoVida(){
		Unidad marine= new Marine();
		
		assertEquals(vidaMarine,marine.getVida());
	}
	
	@Test
	public void testCreoUnidadVerificoNombre(){
		Unidad marine= new Marine();
		
		assertEquals( UnidadesTerran.MARINE,marine.getNombre());
	}
	
	@Test
	public void testVidaDeUnidadEsDaniada(){
		int danioCausado = 20;
		
		Unidad marine= new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(vidaMarine - danioCausado,marine.getVida());
	}
	
	@Test
	public void testUnidadMuereConSuficienteDanio(){
		int danioCausado = 40;
		
		Unidad marine= new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(true, marine.estoyMuerto());
	}
	
	@Test
	public void testUnidadMuereConDemasiadoDanio(){
		int danioCausado = 41;
		
		Unidad marine= new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(true, marine.estoyMuerto());
	}
	
	@Test
	public void testUnidadNoMuereCondanioDeMenos(){
		int danioCausado = 39;
		
		Unidad marine= new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(false, marine.estoyMuerto());
	}
}

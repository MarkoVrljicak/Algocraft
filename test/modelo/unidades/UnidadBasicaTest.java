package modelo.unidades;

import static org.junit.Assert.*;
import modelo.unidades.Unidad;
import modelo.unidades.terran.Marine;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class UnidadBasicaTest {
	

	private static final int vidaMarine = 40;

	@Test
	public void testCreoUnidadVerificoVida(){
		Unidad marine= new Marine();
		
		assertEquals(vidaMarine,marine.getVida());
	}
	
	@Test
	public void testVidaActualEsIgualAVidaMaximaRecienCreado(){
		Unidad marine= new Marine();
		
		assertEquals(marine.getVidaMaxima(),marine.getVida());
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
	public void testUnidadNoMuereConDanioDeMenos(){
		int danioCausado = 39;
		
		Unidad marine= new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(false, marine.estoyMuerto());
	}
}

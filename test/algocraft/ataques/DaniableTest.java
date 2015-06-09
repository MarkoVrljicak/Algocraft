package algocraft.ataques;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construccionesAlternativas.Construccion;
import algocraft.construccionesAlternativas.terran.Barraca;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.terran.Marine;

public class DaniableTest {

	@Test
	public void testVidaDeUnidadEsDaniada(){
		int vidaMarine = 40;
		int danioCausado = 20;
		
		Unidad marine = new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(vidaMarine - danioCausado,marine.getVida());
	}
	
	@Test
	public void testUnidadMatada(){
		int danioCausado = 40;
		
		Unidad marine = new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(true ,marine.estoyMuerto());
	}
	
	@Test
	public void testVidaDeEdificioEsDaniada(){
		int vidaBarraca = 1000;
		int danioCausado = 20;
		
		Construccion barraca = new Barraca();
		barraca.recibirDanio(danioCausado);
		
		assertEquals(vidaBarraca - danioCausado, barraca.getVida());
	}
	
	@Test
	public void testEdificioDestruido(){
		int danioCausado = 1000;
		
		Construccion barraca = new Barraca();
		barraca.recibirDanio(danioCausado);
		
		assertEquals(true, barraca.estoyMuerto());
	}
	

}

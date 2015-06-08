package algocraft.ataques;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;

public class DaniableTest {

	@Test
	public void testVidaDeUnidadEsDaniada(){
		int vidaMarine = 40;
		int danioCausado = 20;
		
		Unidad marine = new Marine();
		marine.recibirDanio(danioCausado);
		
		assertEquals(vidaMarine - danioCausado,marine.getVida());
	}

}
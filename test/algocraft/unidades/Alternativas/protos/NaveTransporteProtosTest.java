package algocraft.unidades.Alternativas.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;



public class NaveTransporteProtosTest {

	@Test
	public void testVerVidaInicialNaveTransporte(){
		
		NaveDeTransporte nave = new NaveDeTransporte();
		
		Assert.assertEquals(150, nave.getVida());
	}
	
	@Test
	public void testNaveTransporteEsVolador(){
		NaveDeTransporte nave = new NaveDeTransporte();
		assertEquals(true, nave.soyVolador());
	}

}

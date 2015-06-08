package algocraft.unidades.Alternativas.protos;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.Alternativas.protos.NaveDeTransporte;



public class NaveTransporteProtosTest {

	@Test
	public void testVerVidaInicialNaveTransporte(){
		
		NaveDeTransporte nave = new NaveDeTransporte();
		
		Assert.assertEquals(150, nave.getVida());
	}

}

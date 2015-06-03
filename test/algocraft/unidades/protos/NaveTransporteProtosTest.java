package algocraft.unidades.protos;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.terran.NaveTransporte;

public class NaveTransporteProtosTest {

	@Test
	public void testVerVidaInicialNaveTransporte(){
		
		NaveTransporte nave = new NaveTransporte();
		
		Assert.assertEquals(150, nave.getVida());
	}

}

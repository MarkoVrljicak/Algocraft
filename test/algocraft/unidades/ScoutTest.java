package algocraft.unidades;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.protos.Scout;

public class ScoutTest {

	@Test
	public void testVerVidaInicialScout(){
		
		Scout scout= new Scout();
		
		Assert.assertEquals(150, scout.getVida());
	}
}

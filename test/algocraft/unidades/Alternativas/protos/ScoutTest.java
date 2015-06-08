package algocraft.unidades.Alternativas.protos;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.Alternativas.protos.Scout;


public class ScoutTest {

	@Test
	public void testVerVidaInicialScout(){
		
		Scout scout= new Scout();
		
		Assert.assertEquals(150, scout.getVida());
	}
}

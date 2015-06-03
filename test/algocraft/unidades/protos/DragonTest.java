package algocraft.unidades.protos;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.protos.Dragon;

public class DragonTest {
	
	@Test
	public void testVerVidaInicialDragon(){
		
		Dragon dragon= new Dragon();
		
		Assert.assertEquals(100,dragon.getVida());
	}
}

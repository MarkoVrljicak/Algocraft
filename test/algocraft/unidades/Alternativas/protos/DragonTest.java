package algocraft.unidades.Alternativas.protos;

import org.junit.Assert;
import org.junit.Test;


public class DragonTest {
	
	@Test
	public void testVerVidaInicialDragon(){
		
		Dragon dragon= new Dragon();
		
		Assert.assertEquals(100,dragon.getVida());
	}
}

package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class NicoTest {

	@Test
	public void doNicoDeberiaDevuelverNico(){
		Nico nico= new Nico();
		
		String resultado= nico.doNico();
		
		Assert.assertEquals("nico",resultado);
	}
}

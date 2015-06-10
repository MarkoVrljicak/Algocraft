package stats;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.stats.Vida;

public class VidaTest {

	@Test
	public void testVidaSigueIgualLuegoDeRegenerar() {
		Vida vida = new Vida(10);
		
		vida.disminuir(1);
		vida.regenerar();
		
		assertEquals(9, vida.actual());
	}

}

package modelo.stats;

import static org.junit.Assert.*;
import modelo.stats.Vida;

import org.junit.Test;

public class VidaTest {

	@Test
	public void testVidaSigueIgualLuegoDeRegenerar() {
		Vida vida = new Vida(10);
		
		vida.disminuir(1);
		vida.regenerar();
		
		assertEquals(9, vida.actual());
	}
	
	@Test
	public void testInicializarVidaConCeroEsValido(){
		Vida vida = new Vida(0);
		
		assertFalse(vida == null);
	}

}

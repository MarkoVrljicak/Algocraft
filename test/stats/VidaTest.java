package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class VidaTest {

	@Test
	public void VidaActualEsInicialmenteIgualAVidaMaxima() {
		Vida vida = new Vida();
		vida.setVida(100);
		
		assertEquals(vida.actual(), vida.maxima());
	}

}

package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagiaTest {

	@Test
	public void MagiaSeRegenera() {
		Magia magia = new Magia();
		magia.set(100);
		
		magia.disminuir(20);
		magia.regenerar(20);
		
		assertEquals(100, magia.actual());
	}

}

package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscudoTest {

	@Test
	public void EscudoActualEsInicialmenteIgualAEscudoMaximo() {
		Escudo escudo = new Escudo();
		escudo.set(100);
		
		assertEquals(escudo.actual(), escudo.max());
	}

}

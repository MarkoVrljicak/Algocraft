package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatTest {

	@Test
	public void EscudoActualEsInicialmenteIgualAEscudoMaximo() {
		Stat escudo = new Escudo();
		escudo.set(100);
		
		assertEquals(escudo.actual(), escudo.max());
	}

}

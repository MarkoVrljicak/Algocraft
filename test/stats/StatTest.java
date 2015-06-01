package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatTest {

	@Test
	public void StatActualEsInicialmenteIgualAStatMaximo() {
		Stat escudo = new Escudo();
		escudo.set(100);
		
		assertEquals(escudo.actual(), escudo.max());
	}
	
	@Test
	public void StatDisminuyeCorrectamente() {
		Stat magia = new Magia();
		magia.set(100);
		magia.disminuir(20);
		
		assertEquals(80, magia.actual());
	}

}

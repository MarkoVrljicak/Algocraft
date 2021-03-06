package modelo.stats;

import static org.junit.Assert.*;
import modelo.stats.Stat;
import modelo.stats.Vida;

import org.junit.Test;

public class StatTest {

	@Test
	public void StatActualEsInicialmenteIgualAStatMaximo() {
		Stat vida = new Vida(100);
		
		assertEquals(vida.actual(), vida.max());
	}
	
	@Test
	public void StatDisminuyeCorrectamente() {
		Stat vida = new Vida(100);
		vida.disminuir(20);
		
		assertEquals(80, vida.actual());
	}
	
	@Test
	public void StatNoBajaDeCero() {
		Stat vida = new Vida(100);
		vida.disminuir(110);
		
		assertEquals(0, vida.actual());
	}
	
	@Test
	public void VidaEstaVaciaEn0() {
		Stat vida = new Vida(100);
		vida.disminuir(100);
		
		assertEquals(true, vida.estoyVacio());
	}

}

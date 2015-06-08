package stats;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagiaTest {

	@Test
	public void MagiaSeRegeneraLaCantidadPasadaAlInicializarse() {
		Magia magia = new Magia(10);
		magia.set(100);
		
		magia.disminuir(20);
		magia.regenerar();
		
		assertEquals(90, magia.actual());
	}
	
	@Test
	public void MagiaParaDeRegenerarseCuandoLlegaAMaximo() {
		Magia magia = new Magia(10);
		magia.set(100);
		
		magia.regenerar();
		
		assertEquals(100, magia.actual());
	}

}

package algocraft.stats;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.stats.Magia;

public class MagiaTest {
	int maximoGenerico = 100;
	int cantidadRegenerada = 10;

	@Test
	public void MagiaSeRegeneraLaCantidadPasadaAlInicializarse() {
		Magia magia = new Magia(maximoGenerico, cantidadRegenerada);
		
		magia.disminuir(20);
		magia.regenerar();
		
		assertEquals(90, magia.actual());
	}
	
	@Test
	public void MagiaParaDeRegenerarseCuandoLlegaAMaximo() {
		Magia magia = new Magia(maximoGenerico, cantidadRegenerada);
		
		magia.regenerar();
		
		assertEquals(100, magia.actual());
	}

}

package algocraft.construcciones.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.Barraca;
import algocraft.unidades.Unidad;

public class BarracaTest {
	public Recurso  muchosRecursos= new Recurso(999,999);
	public String nombreMarine = "Marine";
	private int poblacionSuficiente=5;

	@Test
	public void testConstruyoBarracaYControloSuVidaInicial() {
		Construccion construccion = new Barraca();
		
		assertEquals(1000, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearBarraca() {
		Construccion construccion = new Barraca();
		
		assertEquals(12, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testBarracaInicializaConMarine() {
		Barraca barraca = new Barraca();
		
		assertEquals(true, barraca.tengoUnidad(nombreMarine));
	}
	
	@Test
	public void testBarracaCreaMarine() {
		Barraca barraca = new Barraca();
		Unidad marine = barraca.crearUnidad( muchosRecursos, nombreMarine, poblacionSuficiente);
		
		assertEquals(nombreMarine, marine.getNombre());
	}
}

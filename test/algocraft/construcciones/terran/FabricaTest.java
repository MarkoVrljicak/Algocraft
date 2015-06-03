package algocraft.construcciones.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.Fabrica;
import algocraft.unidades.Unidad;

public class FabricaTest {
	public int poblacionSuficiente=5;
	public Recurso muchosRecursos= new Recurso(999,999);
	String nombreGolliat = "Golliat";

	@Test
	public void testConstruyoFabricaYControloSuVidaInicial() {
		Construccion construccion = new Fabrica();
		
		assertEquals(1250, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearFabrica() {
		Construccion construccion = new Fabrica();
		
		assertEquals(12, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testFabriInicializaConGolliat() {
		Fabrica fabrica = new Fabrica();
		
		assertEquals(true, fabrica.tengoUnidad(nombreGolliat));
	}
	
	@Test
	public void testFabricaCreaGolliat() {
		Fabrica fabrica = new Fabrica();
		Unidad golliat = fabrica.crearUnidad( muchosRecursos, nombreGolliat, poblacionSuficiente);
		
		assertEquals(nombreGolliat, golliat.getNombre());
	}
}


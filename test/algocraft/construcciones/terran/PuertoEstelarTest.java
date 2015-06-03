package algocraft.construcciones.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.PuertoEstelar;
import algocraft.unidades.Unidad;

public class PuertoEstelarTest {

	private Recurso  muchosRecursos = new Recurso(999,999);
	private int poblacionSuficiente=5;
	public String nombreEspectro = "Espectro";
	public String nombreNaveCiencia = "Nave Ciencia";
	public String nombreNaveTransporte = "Nave Transporte";
	
	@Test
	public void testConstruyoPuertoEstelarYControloSuVidaInicial() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(1300, construccion.getVida());
	}

	@Test
	public void testVeoElTiempoDeConstruccionParaCrearPuertoEstelar() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(10, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testPuertoEstelarInicializaConEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreEspectro));
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreNaveCiencia));
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreNaveTransporte));
	}
	
	@Test
	public void testPuertoEstelarCreaEspectro() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Unidad espectro = puertoEstelar.crearUnidad( muchosRecursos, nombreEspectro, poblacionSuficiente);
		
		assertEquals(nombreEspectro, espectro.getNombre());
	}
	
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Unidad nave = puertoEstelar.crearUnidad( muchosRecursos, nombreNaveTransporte, poblacionSuficiente);
		
		assertEquals(nombreNaveTransporte, nave.getNombre());
	}
	
	@Test
	public void testPuertoEstelarCreaNaveCiencia() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		Unidad nave = puertoEstelar.crearUnidad( muchosRecursos, nombreNaveCiencia, poblacionSuficiente);
		
		assertEquals(nombreNaveCiencia, nave.getNombre());
	}
}

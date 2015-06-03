package algocraft.construcciones.protos;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.PuertoEstelar;
import algocraft.unidades.Unidad;

public class PuertoEstelarTest {
	
	private String nombreScout = "Scout";
	private String nombreNaveDeTransporte = "Nave de Transporte";
	private Recurso muchosRecursos=new Recurso(999,999);
	private int poblacionSuficiente=5;


	@Test
	public void testConstruyoPuertoEstelarYControloSuVidaInicial() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(600, construccion.getVida());
	}

	@Test
	public void testVeoElTiempoDeConstruccionParaCrearPuertoEstelar() {
		Construccion construccion = new PuertoEstelar();
		
		assertEquals(10, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testPuertoEstelarInicializaConScout() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreScout));
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		assertEquals(true, puertoEstelar.tengoUnidad(nombreNaveDeTransporte));
	}
	
	@Test
	public void testPuertoEstelarCreaScout(){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		Unidad scout = puertoEstelar.crearUnidad( muchosRecursos, nombreScout, poblacionSuficiente);
		
		assertEquals(nombreScout, scout.getNombre());
	}
	
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte(){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		
		Unidad nave = puertoEstelar.crearUnidad( muchosRecursos, nombreNaveDeTransporte, poblacionSuficiente);
		
		assertEquals(nombreNaveDeTransporte, nave.getNombre());
	}
}

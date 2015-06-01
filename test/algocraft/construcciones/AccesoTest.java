package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.*;

public class AccesoTest {
	
	private String nombreZealot="Zealot";
	private String nombreDragon="Dragon";
	private int muchoMineral=999;
	private int muchoGas=999;

	@Test
	public void testConstruyoAccesoYControloSuVidaInicial() {
		Construccion construccion = new Acceso();
		
		assertEquals(500, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearAcceso() {
		Construccion construccion = new Acceso();
		
		assertEquals(8, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testAccesoInicializaConZealot() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(nombreZealot));
	}
	
	@Test
	public void testAccesoInicializaConDragon() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(nombreDragon));
	}
	
	@Test
	public void testAccesoCreaZealot(){
		Acceso acceso = new Acceso();
		
		Zealot zealot= (Zealot) acceso.crearUnidad(muchoMineral, muchoGas, nombreZealot);
		
		assertEquals(nombreZealot,zealot.getNombre());
	}
	
	@Test
	public void testAccesoCreaDragon(){
		Acceso acceso = new Acceso();
		
		Dragon dragon= (Dragon) acceso.crearUnidad(muchoMineral, muchoGas, nombreDragon);
		
		assertEquals(nombreDragon,dragon.getNombre());
	}
}

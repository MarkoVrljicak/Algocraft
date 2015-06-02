package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.protos.Acceso;
import algocraft.unidades.protos.Dragon;
import algocraft.unidades.protos.Zealot;

public class AccesoTest {
	
	private String nombreZealot="Zealot";
	private String nombreDragon="Dragon";
	private Recurso muchosRecursos=new Recurso(999,999);

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
		
		Zealot zealot= (Zealot) acceso.crearUnidad( muchosRecursos, nombreZealot);
		
		assertEquals(nombreZealot,zealot.getNombre());
	}
	
	@Test
	public void testAccesoCreaDragon(){
		Acceso acceso = new Acceso();
		
		Dragon dragon= (Dragon) acceso.crearUnidad( muchosRecursos, nombreDragon);
		
		assertEquals(nombreDragon,dragon.getNombre());
	}
}

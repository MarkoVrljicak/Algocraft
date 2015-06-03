package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.Acceso;
import algocraft.unidades.Unidad;

public class AccesoTest {
	
	private String nombreZealot="Zealot";
	private String nombreDragon="Dragon";
	private Recurso muchosRecursos=new Recurso(999,999);
	private int poblacionSuficiente=5;

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
		
		Unidad zealot= acceso.crearUnidad( muchosRecursos, nombreZealot, poblacionSuficiente);
		
		assertEquals(nombreZealot,zealot.getNombre());
	}
	
	@Test
	public void testAccesoCreaDragon(){
		Acceso acceso = new Acceso();
		
		Unidad dragon = acceso.crearUnidad( muchosRecursos, nombreDragon, poblacionSuficiente);
		
		assertEquals(nombreDragon,dragon.getNombre());
	}
}

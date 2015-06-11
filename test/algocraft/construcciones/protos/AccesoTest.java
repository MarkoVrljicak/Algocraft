package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.Acceso;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.UnidadesProtos;

public class AccesoTest {
	
	
	private static final Recurso recursosNecesariosZealot = new Recurso(100,0);
	private static final Recurso recursosNecesariosDragon = new Recurso(125,50);
	private static final int poblacionNecesariaZealot = 2;
	private static final int poblacionNecesariaDragon = 2;
	
	@Test
	public void testAccesoInicializaConZealot() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(UnidadesProtos.ZEALOT));
	}
		
	@Test
	public void testAccesoPuedeCrearZealotConRecursosSuficientesyPoblacionSuficiente() {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		acceso.setDuenio(jugador);
			
		assertEquals(true,acceso.puedoCrearUnidad(recursosNecesariosZealot, poblacionNecesariaZealot));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearZealotConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		acceso.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(recursosNecesariosZealot, poblacionNecesariaZealot));
	}
		
	@Test
	public void testAccesoCreaZealot() {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		acceso.setDuenio(jugador);
		Unidad zealot = acceso.crearUnidad(UnidadesProtos.ZEALOT);
		
		assertEquals(UnidadesProtos.ZEALOT, zealot.getNombre());
	}
	
	@Test
	public void testAccesoInicializaConDragon() {
		Acceso acceso = new Acceso();
		
		assertEquals(true, acceso.tengoUnidad(UnidadesProtos.DRAGON));
	}
		
	@Test
	public void testAccesoPuedeCrearDragonConRecursosSuficientesyPoblacionSuficiente() {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(50);
		acceso.setDuenio(jugador);
					
		assertEquals(true,acceso.puedoCrearUnidad(recursosNecesariosDragon, poblacionNecesariaDragon));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearDragonConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		acceso.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(recursosNecesariosDragon, poblacionNecesariaDragon));
	}
		
	@Test
	public void testAccesoCreaDragon() {
		Acceso acceso = new Acceso();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(50);
		acceso.setDuenio(jugador);
		Unidad dragon = acceso.crearUnidad(UnidadesProtos.DRAGON);
		
		assertEquals(UnidadesProtos.DRAGON, dragon.getNombre());
	}
}


package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.CreadorAcceso;
import algocraft.factory.unidadesProtoss.CreadorDragon;
import algocraft.factory.unidadesProtoss.CreadorZealot;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.UnidadesProtos;

public class AccesoTest {
	
	@Test
	public void testAccesoInicializaConZealot() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		
		assertEquals(true, acceso.tengoUnidad(UnidadesProtos.ZEALOT));
	}
		
	@Test
	public void testAccesoPuedeCrearZealotConRecursosSuficientesyPoblacionSuficiente() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		acceso.setDuenio(jugador);
			
		assertEquals(true,acceso.puedoCrearUnidad(new CreadorZealot()));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearZealotConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		acceso.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(new CreadorZealot()));
	}
		
	@Test
	public void testAccesoCreaZealot() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		acceso.setDuenio(jugador);
		Unidad zealot = acceso.crearUnidad(UnidadesProtos.ZEALOT);
		
		assertEquals(UnidadesProtos.ZEALOT, zealot.getNombre());
	}
	
	@Test
	public void testAccesoInicializaConDragon() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		
		assertEquals(true, acceso.tengoUnidad(UnidadesProtos.DRAGON));
	}
		
	@Test
	public void testAccesoPuedeCrearDragonConRecursosSuficientesyPoblacionSuficiente() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(50);
		acceso.setDuenio(jugador);
					
		assertEquals(true,acceso.puedoCrearUnidad(new CreadorDragon()));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearDragonConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		acceso.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(new CreadorDragon()));
	}
		
	@Test
	public void testAccesoCreaDragon() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(50);
		acceso.setDuenio(jugador);
		Unidad dragon = acceso.crearUnidad(UnidadesProtos.DRAGON);
		
		assertEquals(UnidadesProtos.DRAGON, dragon.getNombre());
	}
}


package modelo.construcciones.protos;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosProtoss.CreadorAcceso;
import modelo.factory.unidadesProtoss.CreadorDragon;
import modelo.factory.unidadesProtoss.CreadorZealot;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.protos.UnidadesProtos;

import org.junit.Test;

public class AccesoTest {
	
	private static final int tiempoConstruccionAcceso = 8;

	private CreadorDeUnidades crearAccesoValido() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		for(int turnos = 1 ; turnos<= tiempoConstruccionAcceso ; turnos++)
			try {
				acceso .iniciarTurno();
			} catch (PropiedadNoEstaEnJuegoException e) {
				// no entiendo por que se lanzaria esta excepcion
				e.printStackTrace();
			} catch (PropiedadNoExisteEnEstaUbicacion e) {
				e.printStackTrace();
			}
		return acceso;
	}
	
	@Test
	public void testAccesoInicializaConZealot() {
		CreadorDeUnidades acceso = crearAccesoValido();
		
		assertEquals(true, acceso.tengoUnidad(UnidadesProtos.ZEALOT));
	}
		
	@Test
	public void testAccesoPuedeCrearZealotConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades acceso = crearAccesoValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		acceso.setDuenio(jugador);
			
		assertEquals(true,acceso.puedoCrearUnidad(new CreadorZealot()));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearZealotConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades acceso = crearAccesoValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		acceso.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(new CreadorZealot()));
	}
		
	@Test
	public void testAccesoCreaZealot() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, 
			RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		
		CreadorDeUnidades acceso = crearAccesoValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		acceso.setDuenio(jugador);
		Unidad zealot = acceso.crearUnidad(UnidadesProtos.ZEALOT);
		
		assertEquals(UnidadesProtos.ZEALOT, zealot.getNombre());
	}
	
	@Test
	public void testAccesoInicializaConDragon() {
		CreadorDeUnidades acceso = crearAccesoValido();
		
		assertEquals(true, acceso.tengoUnidad(UnidadesProtos.DRAGON));
	}
		
	@Test
	public void testAccesoPuedeCrearDragonConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades acceso = crearAccesoValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		jugador.incrementarGas(50);
		acceso.setDuenio(jugador);
					
		assertEquals(true,acceso.puedoCrearUnidad(new CreadorDragon()));
	}	
		
	@Test
	public void testAccesoNoPuedeCrearDragonConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades acceso = crearAccesoValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		acceso.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,acceso.puedoCrearUnidad(new CreadorDragon()));
	}
		
	@Test
	public void testAccesoCreaDragon() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, 
			RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		
		CreadorDeUnidades acceso = crearAccesoValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		jugador.incrementarGas(50);
		acceso.setDuenio(jugador);
		Unidad dragon = acceso.crearUnidad(UnidadesProtos.DRAGON);
		
		assertEquals(UnidadesProtos.DRAGON, dragon.getNombre());
	}
}


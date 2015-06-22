package modelo.construcciones.protos;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosProtoss.CreadorPuertoEstelar;
import modelo.factory.unidadesProtoss.CreadorNaveDeTransporte;
import modelo.factory.unidadesProtoss.CreadorScout;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.protos.UnidadesProtos;

import org.junit.Test;

public class PuertoEstelarTest {
	
	@Test
	public void testPuertoEstelarInicializaConScout() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesProtos.SCOUT));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearScoutConRecursosSuficientesyPoblacionSuficiente() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		jugador.incrementarMineral(100);
		jugador.incrementarGas(150);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorScout()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearScoutConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorScout()));
	}
		
	@Test
	public void testPuertoEstelarCreaScout() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);		
		jugador.incrementarMineral(100);
		jugador.incrementarGas(150);
		puertoEstelar.setDuenio(jugador);
		Unidad scout = puertoEstelar.crearUnidad(UnidadesProtos.SCOUT);
		
		assertEquals(UnidadesProtos.SCOUT, scout.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesProtos.NAVE_DE_TRANSPORTE));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
					
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorNaveDeTransporte()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorNaveDeTransporte()));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);		
		jugador.incrementarGas(50);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesProtos.NAVE_DE_TRANSPORTE);
		
		assertEquals(UnidadesProtos.NAVE_DE_TRANSPORTE, nave.getNombre());
	}
}


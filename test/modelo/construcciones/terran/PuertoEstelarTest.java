package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosTerran.CreadorPuertoEstelar;
import modelo.factory.unidadesTerran.CreadorEspectro;
import modelo.factory.unidadesTerran.CreadorNaveCiencia;
import modelo.factory.unidadesTerran.CreadorNaveTransporte;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class PuertoEstelarTest {
	
	private static final int tiempoConstruccionPuertoEstelar = 10;

	private CreadorDeUnidades crearPuertoEstelarValido() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		for(int turnos = 1 ; turnos<= tiempoConstruccionPuertoEstelar ; turnos++)
			try {
				puertoEstelar .iniciarTurno();
			} catch (PropiedadNoEstaEnJuegoException e) {
				// no entiendo por que se lanzaria esta excepcion
				e.printStackTrace();
			}
		return puertoEstelar;
	}
	
	@Test
	public void testPuertoEstelarInicializaConEspectro() {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.ESPECTRO));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearEspectroConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorEspectro()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearEspectroConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorEspectro()));
	}
		
	@Test
	public void testPuertoEstelarCreaEspectro()
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
		
		Unidad espectro = puertoEstelar.crearUnidad(UnidadesTerran.ESPECTRO);
		
		assertEquals(UnidadesTerran.ESPECTRO, espectro.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.NAVE_TRANSPORTE));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorNaveTransporte()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorNaveTransporte()));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesTerran.NAVE_TRANSPORTE);
		
		assertEquals(UnidadesTerran.NAVE_TRANSPORTE, nave.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeCiencia() {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.NAVE_CIENCIA));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeCienciaConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorNaveCiencia()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeCienciaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorNaveCiencia()));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeCiencia() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException {
		CreadorDeUnidades puertoEstelar = crearPuertoEstelarValido();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesTerran.NAVE_CIENCIA);
		
		assertEquals(UnidadesTerran.NAVE_CIENCIA, nave.getNombre());
	}
}

package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.CondicionesInsuficientesException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosTerran.CreadorPuertoEstelar;
import algocraft.factory.unidadesTerran.CreadorEspectro;
import algocraft.factory.unidadesTerran.CreadorNaveCiencia;
import algocraft.factory.unidadesTerran.CreadorNaveTransporte;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.UnidadesTerran;

public class PuertoEstelarTest {
	
	@Test
	public void testPuertoEstelarInicializaConEspectro() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.ESPECTRO));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearEspectroConRecursosSuficientesyPoblacionSuficiente() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorEspectro()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearEspectroConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorEspectro()));
	}
		
	@Test
	public void testPuertoEstelarCreaEspectro() throws CondicionesInsuficientesException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
		
		Unidad espectro = puertoEstelar.crearUnidad(UnidadesTerran.ESPECTRO);
		
		assertEquals(UnidadesTerran.ESPECTRO, espectro.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeTransporte() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.NAVE_TRANSPORTE));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeTransporteConRecursosSuficientesyPoblacionSuficiente() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorNaveTransporte()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeTransporteConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorNaveTransporte()));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeTransporte() throws CondicionesInsuficientesException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesTerran.NAVE_TRANSPORTE);
		
		assertEquals(UnidadesTerran.NAVE_TRANSPORTE, nave.getNombre());
	}
	
	@Test
	public void testPuertoEstelarInicializaConNaveDeCiencia() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		
		assertEquals(true, puertoEstelar.tengoUnidad(UnidadesTerran.NAVE_CIENCIA));
	}
		
	@Test
	public void testPuertoEstelarPuedeCrearNaveDeCienciaConRecursosSuficientesyPoblacionSuficiente() {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
			
		assertEquals(true,puertoEstelar.puedoCrearUnidad(new CreadorNaveCiencia()));
	}	
		
	@Test
	public void testPuertoEstelarNoPuedeCrearNaveDeCienciaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		puertoEstelar.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,puertoEstelar.puedoCrearUnidad(new CreadorNaveCiencia()));
	}
		
	@Test
	public void testPuertoEstelarCreaNaveDeCiencia() throws CondicionesInsuficientesException {
		CreadorPuertoEstelar creador = new CreadorPuertoEstelar();
		CreadorDeUnidades puertoEstelar = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		puertoEstelar.setDuenio(jugador);
		Unidad nave = puertoEstelar.crearUnidad(UnidadesTerran.NAVE_CIENCIA);
		
		assertEquals(UnidadesTerran.NAVE_CIENCIA, nave.getNombre());
	}
}

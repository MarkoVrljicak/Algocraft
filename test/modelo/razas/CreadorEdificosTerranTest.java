package modelo.razas;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.Construccion;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.CreadorBarraca;
import modelo.factory.edificiosTerran.CreadorCentroDeMineral;
import modelo.factory.edificiosTerran.CreadorDepositoDeSuministros;
import modelo.factory.edificiosTerran.CreadorFabrica;
import modelo.factory.edificiosTerran.CreadorPuertoEstelar;
import modelo.factory.edificiosTerran.CreadorRefineria;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.CreadorDeEdificiosTerran;
import modelo.razas.EnumRazas;

import org.junit.Test;

public class CreadorEdificosTerranTest {

	@Test
	public void testTerranInicializaConCentroMineral() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.CENTRO_DE_MINERALES));
	}
	
	@Test
	public void testTerranInicializaConBarraca() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.BARRACA));
	}
	
	@Test
	public void testTerranInicializaConDepositoDeSuministros() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS));
	}
	
	@Test
	public void testTerranInicializaConRefineria() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.REFINERIA));
	}
	
	@Test
	public void testTerrranInicializaConFabrica() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.FABRICA));
	}
	
	@Test
	public void testTerranInicializaConPuertoEstelar() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.PUERTO_ESTELAR));
	}
	
	@Test
	public void testTerranNoTieneNexoMineral() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(false, terran.tengoConstruccion(EnumEdificiosProtos.NEXO_MINERAL));
	}
	
	@Test
	public void testTerranPuedeCrearBarracaConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorBarraca()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearBarracaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorBarraca()));
	}
		
	@Test
	public void testTerranCreaBarraca()
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion barraca = terran.crearConstruccion(EnumEdificiosTerran.BARRACA);
		
		assertEquals(EnumEdificiosTerran.BARRACA, barraca.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearCentroDeMineralConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorCentroDeMineral()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearCentroDeMineralConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorCentroDeMineral()));
	}
		
	@Test
	public void testTerranCreaCentroDeMineral() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion centroDeMineral = terran.crearConstruccion(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		
		assertEquals(EnumEdificiosTerran.CENTRO_DE_MINERALES, centroDeMineral.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearDepositoDeSuministrosConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorDepositoDeSuministros()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearDepositoDeSuministrosConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorDepositoDeSuministros()));
	}
		
	@Test
	public void testTerranCreaDepositoDeSuministros() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion depositoDeSuministros = terran.crearConstruccion(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS);
		
		assertEquals(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, depositoDeSuministros.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearFabricaConRecursosSuficientesyPoblacionSuficiente()
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		jugador.construir(EnumEdificiosTerran.BARRACA);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorFabrica()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearFabricaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorFabrica()));
	}
		
	@Test
	public void testTerranPuedeCrearPuertoEstelarConRecursosSuficientesyPoblacionSuficiente() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		jugador.construir(EnumEdificiosTerran.BARRACA);
		jugador.construir(EnumEdificiosTerran.FABRICA);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearPuertoEstelarConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}
		
	@Test
	public void testTerranPuedeCrearRefineriaConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorRefineria()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearRefineriaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorRefineria()));
	}
		
	@Test
	public void testTerranCreaRefineria() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion refineria = terran.crearConstruccion(EnumEdificiosTerran.REFINERIA);
		
		assertEquals(EnumEdificiosTerran.REFINERIA, refineria.getNombre());
	}

	@Test
	public void testTerranEmpiezaConSieteConstruccionesDisponibles(){
		CreadorDeEdificiosTerran terran = new CreadorDeEdificiosTerran();
		
		assertEquals(7, terran.getListaDeConstrucciones().size());
	}

}

package algocraft.razas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.exception.DependenciasNoCumplidasException;
import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.factory.edificiosTerran.CreadorBarraca;
import algocraft.factory.edificiosTerran.CreadorCentroDeMineral;
import algocraft.factory.edificiosTerran.CreadorDepositoDeSuministros;
import algocraft.factory.edificiosTerran.CreadorFabrica;
import algocraft.factory.edificiosTerran.CreadorPuertoEstelar;
import algocraft.factory.edificiosTerran.CreadorRefineria;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;

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

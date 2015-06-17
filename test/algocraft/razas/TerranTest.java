package algocraft.razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.exception.CondicionesInsuficientesException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.factory.edificiosTerran.*;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;

public class TerranTest {

	@Test
	public void testTerranInicializaConCentroMineral() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.CENTRO_DE_MINERALES));
	}
	
	@Test
	public void testTerranInicializaConBarraca() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.BARRACA));
	}
	
	@Test
	public void testTerranInicializaConDepositoDeSuministros() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS));
	}
	
	@Test
	public void testTerranInicializaConRefineria() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.REFINERIA));
	}
	
	@Test
	public void testTerrranInicializaConFabrica() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.FABRICA));
	}
	
	@Test
	public void testTerranInicializaConPuertoEstelar() {
		Terran terran = new Terran();
		
		assertEquals(true, terran.tengoConstruccion(EnumEdificiosTerran.PUERTO_ESTELAR));
	}
	
	@Test
	public void testTerranNoTieneNexoMineral() {
		Terran terran = new Terran();
		
		assertEquals(false, terran.tengoConstruccion(EnumEdificiosProtos.NEXO_MINERAL));
	}
	
	@Test
	public void testTerranPuedeCrearBarracaConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorBarraca()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearBarracaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorBarraca()));
	}
		
	@Test
	public void testTerranCreaBarraca() throws CondicionesInsuficientesException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion barraca = terran.crearConstruccion(EnumEdificiosTerran.BARRACA);
		
		assertEquals(EnumEdificiosTerran.BARRACA, barraca.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearCentroDeMineralConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorCentroDeMineral()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearCentroDeMineralConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorCentroDeMineral()));
	}
		
	@Test
	public void testTerranCreaCentroDeMineral() throws CondicionesInsuficientesException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion centroDeMineral = terran.crearConstruccion(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		
		assertEquals(EnumEdificiosTerran.CENTRO_DE_MINERALES, centroDeMineral.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearDepositoDeSuministrosConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorDepositoDeSuministros()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearDepositoDeSuministrosConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorDepositoDeSuministros()));
	}
		
	@Test
	public void testTerranCreaDepositoDeSuministros() throws CondicionesInsuficientesException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion depositoDeSuministros = terran.crearConstruccion(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS);
		
		assertEquals(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS, depositoDeSuministros.getNombre());
	}
	
	@Test
	public void testTerranPuedeCrearFabricaConRecursosSuficientesyPoblacionSuficiente()
			throws CondicionesInsuficientesException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		jugador.construir(EnumEdificiosTerran.BARRACA);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorFabrica()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearFabricaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorFabrica()));
	}
		
	@Test
	public void testTerranPuedeCrearPuertoEstelarConRecursosSuficientesyPoblacionSuficiente() 
			throws CondicionesInsuficientesException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
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
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}
		
	@Test
	public void testTerranPuedeCrearRefineriaConRecursosSuficientesyPoblacionSuficiente() {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		terran.setDuenio(jugador);
			
		assertEquals(true,terran.puedoCrearConstruccion(new CreadorRefineria()));
	}	
		
	@Test
	public void testTerranNoPuedeCrearRefineriaConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,terran.puedoCrearConstruccion(new CreadorRefineria()));
	}
		
	@Test
	public void testTerranCreaRefineria() throws CondicionesInsuficientesException {
		Terran terran = new Terran();
		Jugador jugador = new Jugador("Nombre", terran, Colores.AZUL);
		
		terran.setDuenio(jugador);
		Construccion refineria = terran.crearConstruccion(EnumEdificiosTerran.REFINERIA);
		
		assertEquals(EnumEdificiosTerran.REFINERIA, refineria.getNombre());
	}

	@Test
	public void testTerranEmpiezaConSieteConstruccionesDisponibles(){
		Terran terran = new Terran();
		
		assertEquals(7, terran.getListaDeConstrucciones().size());
	}

}

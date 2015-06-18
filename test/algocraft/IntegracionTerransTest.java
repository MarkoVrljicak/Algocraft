package algocraft;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algocraft.exception.DependenciasNoCumplidasException;
import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.EnumRazas;

public class IntegracionTerransTest {
	
	private Jugador nuevoJugadorTerran() {
		Jugador jugador = new Jugador("pepe", EnumRazas.TERRAN, Colores.AZUL);
		return jugador;
	}
	
	private Jugador inicializarJugadorConMuchosRecursos()
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = nuevoJugadorTerran();
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		return jugador;
	}

	@Test
	public void testCrearCentroDeMineral() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = nuevoJugadorTerran();
		jugador.construir( EnumEdificiosTerran.CENTRO_DE_MINERALES);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.CENTRO_DE_MINERALES));
	}
	
	@Test
	public void testCrearBarraca() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = nuevoJugadorTerran();
		jugador.construir( EnumEdificiosTerran.BARRACA);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.BARRACA));
	}
	
	@Test
	public void testCrearDepositoDeSuministros() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = nuevoJugadorTerran();
		jugador.construir( EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.DEPOSITO_DE_SUMINISTROS));
	}
	
	@Test
	public void testCrearRefineria() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = nuevoJugadorTerran();
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.REFINERIA));
	}
	
	@Test
	public void testCrearFabrica() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = inicializarJugadorConMuchosRecursos();
		//creo edificios necesarios
		jugador.construir(EnumEdificiosTerran.BARRACA);
		
		//creo fabrica
		jugador.construir(EnumEdificiosTerran.FABRICA);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.FABRICA));
	}
	
	@Test(expected = DependenciasNoCumplidasException.class)
	public void testNoSeCreaFabricaSinBarraca() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = inicializarJugadorConMuchosRecursos();
		
		
		//creo fabrica sin tener barraca
		jugador.construir(EnumEdificiosTerran.FABRICA);
	}
	
	@Test
	public void testCrearPuertoEstelar() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = inicializarJugadorConMuchosRecursos();
		//creo edificios necesarios
		jugador.construir(EnumEdificiosTerran.BARRACA);
		jugador.construir(EnumEdificiosTerran.FABRICA);

		//creo puerto estelar
		jugador.construir( EnumEdificiosTerran.PUERTO_ESTELAR);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosTerran.PUERTO_ESTELAR));
	}
	
	@Test(expected =DependenciasNoCumplidasException.class)
	public void testNoSeCreaPuertoEstelarSinFabrica() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		Jugador jugador = inicializarJugadorConMuchosRecursos();

		//creo puerto estelar
		jugador.construir( EnumEdificiosTerran.PUERTO_ESTELAR);
	}

}

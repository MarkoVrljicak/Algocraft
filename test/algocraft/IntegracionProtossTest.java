package algocraft;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algocraft.exception.CondicionesInsuficientesException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;

public class IntegracionProtossTest {

	private Jugador crearJugadorConMuchosRecursos()
			throws CondicionesInsuficientesException {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.ASIMILADOR);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		return jugador;
	}
	
	@Test
	public void testCrearAcceso() throws CondicionesInsuficientesException {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir(EnumEdificiosProtos.ACCESO);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.ACCESO));
	}
	
	@Test
	public void testCrearAsimilador() throws CondicionesInsuficientesException {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir( EnumEdificiosProtos.ASIMILADOR);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.ASIMILADOR));
	}
	
	@Test
	public void testCrearNexoMineral() throws CondicionesInsuficientesException {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir(  EnumEdificiosProtos.NEXO_MINERAL);
		
		assertTrue(jugador.tieneConstruccion( EnumEdificiosProtos.NEXO_MINERAL));
	}
	
	@Test
	public void testCrearPilon() throws CondicionesInsuficientesException {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir(EnumEdificiosProtos.PILON);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.PILON));
	}

	@Test
	public void testCrearPuertoEstelar() throws CondicionesInsuficientesException {
		Jugador jugador = crearJugadorConMuchosRecursos();
		//creo edificios necesarios
		jugador.construir(EnumEdificiosProtos.ACCESO);
		
		//creo PuertoEstelar
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.PUERTO_ESTELAR));
	}

	
	
	@Test(expected = CondicionesInsuficientesException.class)
	public void testNoSeCreaPuertoEstelarSinAcceso() throws CondicionesInsuficientesException {
		Jugador jugador = crearJugadorConMuchosRecursos();
				
		//creo PuertoEstelar sin tener Acceso
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
	}
	
	@Test
	public void testCrearArchivosTemplarios() throws CondicionesInsuficientesException {
		Jugador jugador = crearJugadorConMuchosRecursos();
		//creo edificios necesarios
		jugador.construir(EnumEdificiosProtos.ACCESO);
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		
		//creo ArchivosTemplarios
		jugador.construir(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS));
	}
	
	@Test(expected = CondicionesInsuficientesException.class)
	public void testNoSeCreaArchivosTemplariosSinPuertoEstelar() throws CondicionesInsuficientesException {
		Jugador jugador = crearJugadorConMuchosRecursos();
		
		//creo ArchivosTemplarios
		jugador.construir(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS);
	}
}

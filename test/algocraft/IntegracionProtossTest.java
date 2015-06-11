package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;

public class IntegracionProtossTest {

	
	
	@Test
	public void testCrearAcceso() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir(EnumEdificiosProtos.ACCESO);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.ACCESO));
	}
	
	@Test
	public void testCrearAsimilador() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir( EnumEdificiosProtos.ASIMILADOR);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.ASIMILADOR));
	}
	
	@Test
	public void testCrearNexoMineral() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir(  EnumEdificiosProtos.NEXO_MINERAL);
		
		assertTrue(jugador.tieneConstruccion( EnumEdificiosProtos.NEXO_MINERAL));
	}
	
	@Test
	public void testCrearPilon() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		jugador.construir(EnumEdificiosProtos.PILON);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.PILON));
	}

	@Test
	public void testCrearPuertoEstelar() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.ASIMILADOR);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios necesarios
		jugador.construir(EnumEdificiosProtos.ACCESO);
		
		//creo PuertoEstelar
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.PUERTO_ESTELAR));
	}
	
	@Test
	public void testNoSeCreaPuertoEstelarSinAcceso() {
		Jugador jugador = new Jugador("pepe", new Protoss(),Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.ASIMILADOR);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
				
		//creo PuertoEstelar sin tener Acceso
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		
		assertFalse(jugador.tieneConstruccion(EnumEdificiosProtos.PUERTO_ESTELAR));
	}
	
	@Test
	public void testCrearArchivosTemplarios() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.ASIMILADOR);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios necesarios
		jugador.construir(EnumEdificiosProtos.ACCESO);
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		
		//creo ArchivosTemplarios
		jugador.construir(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS);
		
		assertTrue(jugador.tieneConstruccion(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS));
	}
	
	@Test
	public void testNoSeCreaArchivosTemplariosSinPuertoEstelar() {
		Jugador jugador = new Jugador("pepe", new Protoss(), Colores.AZUL);
		//construyo edificios para acumular recursos 
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir( EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.ASIMILADOR);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		
		//creo ArchivosTemplarios
		jugador.construir(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS);
		
		assertFalse(jugador.tieneConstruccion(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS));
	}
}

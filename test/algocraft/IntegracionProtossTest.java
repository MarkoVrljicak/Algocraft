package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;

public class IntegracionProtossTest {

	private Colores colorAzul = Colores.AZUL;
	private static final EnumEdificiosProtos nombreAcceso= EnumEdificiosProtos.ACCESO;
	private static final EnumEdificiosProtos nombreArchivosTemplarios= EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS;
	private static final EnumEdificiosProtos nombreAsimilador= EnumEdificiosProtos.ASIMILADOR;
	private static final EnumEdificiosProtos nombreNexoMineral= EnumEdificiosProtos.NEXO_MINERAL;
	private static final EnumEdificiosProtos nombrePuertoEstelar= EnumEdificiosProtos.PUERTO_ESTELAR;
	private static final EnumEdificiosProtos nombrePilon= EnumEdificiosProtos.PILON;
	
	@Test
	public void testCrearAcceso() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		jugador.construir(nombreAcceso);
		
		assertTrue(jugador.tieneConstruccion(nombreAcceso));
	}
	
	@Test
	public void testCrearAsimilador() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		jugador.construir( nombreAsimilador);
		
		assertTrue(jugador.tieneConstruccion(nombreAsimilador));
	}
	
	@Test
	public void testCrearNexoMineral() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		jugador.construir( nombreNexoMineral);
		
		assertTrue(jugador.tieneConstruccion(nombreNexoMineral));
	}
	
	@Test
	public void testCrearPilon() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		jugador.construir(nombrePilon);
		
		assertTrue(jugador.tieneConstruccion(nombrePilon));
	}

	@Test
	public void testCrearPuertoEstelar() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreAsimilador);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios necesarios
		jugador.construir(nombreAcceso);
		
		//creo PuertoEstelar
		jugador.construir(nombrePuertoEstelar);
		
		assertTrue(jugador.tieneConstruccion(nombrePuertoEstelar));
	}
	
	@Test
	public void testNoSeCreaPuertoEstelarSinAcceso() {
		Jugador jugador = new Jugador("pepe", new Protoss(),colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreAsimilador);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
				
		//creo PuertoEstelar sin tener Acceso
		jugador.construir(nombrePuertoEstelar);
		
		assertFalse(jugador.tieneConstruccion(nombrePuertoEstelar));
	}
	
	@Test
	public void testCrearArchivosTemplarios() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreAsimilador);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios necesarios
		jugador.construir(nombreAcceso);
		jugador.construir(nombrePuertoEstelar);
		
		//creo ArchivosTemplarios
		jugador.construir(nombreArchivosTemplarios);
		
		assertTrue(jugador.tieneConstruccion(nombreArchivosTemplarios));
	}
	
	@Test
	public void testNoSeCreaArchivosTemplariosSinPuertoEstelar() {
		Jugador jugador = new Jugador("pepe", new Protoss(), colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreNexoMineral);
		jugador.construir(nombreAsimilador);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		
		//creo ArchivosTemplarios
		jugador.construir(nombreArchivosTemplarios);
		
		assertFalse(jugador.tieneConstruccion(nombreArchivosTemplarios));
	}
}

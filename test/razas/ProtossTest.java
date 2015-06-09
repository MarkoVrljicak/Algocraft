package razas;

import static org.junit.Assert.*;
import jugador.Jugador;
import org.junit.Test;
import algocraft.construccionesAlternativas.Construccion;
import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import algocraft.exception.RecursosNegativosException;
import razasAlternativas.Protoss;
import stats.Recurso;

public class ProtossTest {

	private static final EnumEdificiosProtos nombreAcceso= EnumEdificiosProtos.ACCESO;
	private static final EnumEdificiosProtos nombreArchivosTemplarios= EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS;
	private static final EnumEdificiosProtos nombreAsimilador= EnumEdificiosProtos.ASIMILADOR;
	private static final EnumEdificiosProtos nombreNexoMineral= EnumEdificiosProtos.NEXO_MINERAL;
	private static final EnumEdificiosProtos nombrePuertoEstelar= EnumEdificiosProtos.PUERTO_ESTELAR;
	private static final EnumEdificiosProtos nombrePilon= EnumEdificiosProtos.PILON;
	private static final Recurso recursosNecesariosAcceso = new Recurso(150,0);
	private static final Recurso recursosNecesariosArchivosTemplarios = new Recurso(150,200);
	private static final Recurso recursosNecesariosAsimilador = new Recurso(100,0);
	private static final Recurso recursosNecesariosNexoMineral = new Recurso(50,0);
	private static final Recurso recursosNecesariosPuertoEstelar = new Recurso(150,100);
	private static final Recurso recursosNecesariosPilon = new Recurso(100,0);
	

	@Test
	public void testProtossInicializaConAcceso() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreAcceso));
	}
	
	@Test
	public void testProtossInicializaConArchivosTemplarios() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreArchivosTemplarios ));
	}
	
	@Test
	public void testProtossInicializaConAsimilador() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreAsimilador ));
	}
	
	@Test
	public void testProtossInicializaConNexoMineral() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreNexoMineral ));
	}
	
	@Test
	public void testProtossInicializaConPilon() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombrePilon ));
	}
	
	@Test
	public void testProtossInicializaConPuertoEstelar() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombrePuertoEstelar ));
	}
	
	@Test
	public void testProtossPuedeCrearAccesoConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosAcceso));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAccesoConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosAcceso));
	}
		
	@Test
	public void testProtossCreaAcceso() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		Construccion acceso = protoss.crearConstruccion(nombreAcceso);
		
		assertEquals(nombreAcceso, acceso.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearArchivosTemplariosConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		jugador.getRecursos().incrementarGas(200);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosArchivosTemplarios));
	}	
		
	@Test
	public void testProtossNoPuedeCrearArchivosTemplariosConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosArchivosTemplarios));
	}
		
	@Test
	public void testProtossPuedeCrearAsimiladorConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosAsimilador));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAsimiladorConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosAsimilador));
	}
		
	@Test
	public void testProtossCreaAsimilador() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		Construccion asimilador = protoss.crearConstruccion(nombreAsimilador);
		
		assertEquals(nombreAsimilador, asimilador.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearNexoMineralConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosNexoMineral));
	}	
		
	@Test
	public void testProtossNoPuedeCrearNexoMineralConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosNexoMineral));
	}
		
	@Test
	public void testProtossCreaNexoMineral() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		Construccion nexoMineral = protoss.crearConstruccion(nombreNexoMineral);
		
		assertEquals(nombreNexoMineral, nexoMineral.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearPuertoEstelarConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		jugador.getRecursos().incrementarGas(100);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosPuertoEstelar));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPuertoEstelarConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosPuertoEstelar));
	}
	
	@Test
	public void testProtossPuedeCrearPilonConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosPilon));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPilonConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosPilon));
	}
		
	@Test
	public void testProtossCreaPilon() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss);
		
		protoss.setDuenio(jugador);
		Construccion pilon = protoss.crearConstruccion(nombrePilon);
		
		assertEquals(nombrePilon, pilon.getNombre());
	}

	@Test
	public void testProtossEmpiezaConSieteConstruccionesDisponibles(){
		Protoss protoss = new Protoss();
		
		assertEquals(7, protoss.getListaDeConstrucciones().size());
	}
}
	

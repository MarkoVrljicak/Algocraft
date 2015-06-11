package algocraft.razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.EnumEdificiosProtos;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.stats.Recurso;

public class ProtossTest {
	
	
	private static final Recurso recursosNecesariosAcceso = new Recurso(150,0);
	private static final Recurso recursosNecesariosArchivosTemplarios = new Recurso(150,200);
	private static final Recurso recursosNecesariosAsimilador = new Recurso(100,0);
	private static final Recurso recursosNecesariosNexoMineral = new Recurso(50,0);
	private static final Recurso recursosNecesariosPuertoEstelar = new Recurso(150,100);
	private static final Recurso recursosNecesariosPilon = new Recurso(100,0);
	

	@Test
	public void testProtossInicializaConAcceso() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.ACCESO));
	}
	
	@Test
	public void testProtossInicializaConArchivosTemplarios() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS ));
	}
	
	@Test
	public void testProtossInicializaConAsimilador() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.ASIMILADOR ));
	}
	
	@Test
	public void testProtossInicializaConNexoMineral() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.NEXO_MINERAL ));
	}
	
	@Test
	public void testProtossInicializaConPilon() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.PILON ));
	}
	
	@Test
	public void testProtossInicializaConPuertoEstelar() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.PUERTO_ESTELAR ));
	}
	
	@Test
	public void testProtossPuedeCrearAccesoConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosAcceso));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAccesoConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosAcceso));
	}
		
	@Test
	public void testProtossCreaAcceso() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion acceso = protoss.crearConstruccion(EnumEdificiosProtos.ACCESO);
		
		assertEquals(EnumEdificiosProtos.ACCESO, acceso.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearArchivosTemplariosConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(200);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosArchivosTemplarios));
	}	
		
	@Test
	public void testProtossNoPuedeCrearArchivosTemplariosConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosArchivosTemplarios));
	}
		
	@Test
	public void testProtossPuedeCrearAsimiladorConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss, Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosAsimilador));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAsimiladorConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss, Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosAsimilador));
	}
		
	@Test
	public void testProtossCreaAsimilador() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion asimilador = protoss.crearConstruccion(EnumEdificiosProtos.ASIMILADOR);
		
		assertEquals(EnumEdificiosProtos.ASIMILADOR, asimilador.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearNexoMineralConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosNexoMineral));
	}	
		
	@Test
	public void testProtossNoPuedeCrearNexoMineralConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosNexoMineral));
	}
		
	@Test
	public void testProtossCreaNexoMineral() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion nexoMineral = protoss.crearConstruccion(EnumEdificiosProtos.NEXO_MINERAL);
		
		assertEquals(EnumEdificiosProtos.NEXO_MINERAL, nexoMineral.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearPuertoEstelarConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(100);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosPuertoEstelar));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPuertoEstelarConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosPuertoEstelar));
	}
	
	@Test
	public void testProtossPuedeCrearPilonConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(recursosNecesariosPilon));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPilonConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(recursosNecesariosPilon));
	}
		
	@Test
	public void testProtossCreaPilon() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion pilon = protoss.crearConstruccion(EnumEdificiosProtos.PILON);
		
		assertEquals(EnumEdificiosProtos.PILON, pilon.getNombre());
	}

	@Test
	public void testProtossEmpiezaConSieteConstruccionesDisponibles(){
		Protoss protoss = new Protoss();
		
		assertEquals(7, protoss.getListaDeConstrucciones().size());
	}
}
	

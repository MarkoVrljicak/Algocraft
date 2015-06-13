package algocraft.razas;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.*;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;

public class ProtossTest {
	
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
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorAcceso()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAccesoConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorAcceso()));
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
		
		jugador.getRecursos().incrementarGas(1000);
		jugador.getRecursos().incrementarMineral(1000);
		jugador.construir(EnumEdificiosProtos.ACCESO);
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorArchivosTemplarios()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearArchivosTemplariosConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorArchivosTemplarios()));
	}
		
	@Test
	public void testProtossPuedeCrearAsimiladorConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss, Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorAsimilador()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAsimiladorConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss, Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorAsimilador()));
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
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorNexoMineral()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearNexoMineralConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorNexoMineral()));
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
		
		jugador.getRecursos().incrementarMineral(150);
		jugador.getRecursos().incrementarGas(100);
		jugador.construir(EnumEdificiosProtos.ACCESO);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPuertoEstelarConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}
	
	@Test
	public void testProtossPuedeCrearPilonConRecursosSuficientesyPoblacionSuficiente() {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorPilon()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPilonConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		Protoss protoss = new Protoss();
		Jugador jugador = new Jugador("Nombre", protoss,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.getRecursos().consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorPilon()));
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
	

package modelo.razas;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.Construccion;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosProtoss.CreadorAcceso;
import modelo.factory.edificiosProtoss.CreadorArchivosTemplarios;
import modelo.factory.edificiosProtoss.CreadorAsimilador;
import modelo.factory.edificiosProtoss.CreadorNexoMineral;
import modelo.factory.edificiosProtoss.CreadorPilon;
import modelo.factory.edificiosProtoss.CreadorPuertoEstelar;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.CreadorDeEdificiosProtoss;
import modelo.razas.EnumRazas;

import org.junit.Test;

public class CreadorEdificiosProtossTest {
	
	@Test
	public void testProtossInicializaConAcceso() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.ACCESO));
	}
	
	@Test
	public void testProtossInicializaConArchivosTemplarios() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.ARCHIVOS_TEMPLARIOS ));
	}
	
	@Test
	public void testProtossInicializaConAsimilador() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.ASIMILADOR ));
	}
	
	@Test
	public void testProtossInicializaConNexoMineral() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.NEXO_MINERAL ));
	}
	
	@Test
	public void testProtossInicializaConPilon() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.PILON ));
	}
	
	@Test
	public void testProtossInicializaConPuertoEstelar() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(true, protoss.tengoConstruccion(EnumEdificiosProtos.PUERTO_ESTELAR ));
	}
	
	@Test
	public void testProtossPuedeCrearAccesoConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorAcceso()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAccesoConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorAcceso()));
	}
		
	@Test
	public void testProtossCreaAcceso() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion acceso = protoss.crearConstruccion(EnumEdificiosProtos.ACCESO);
		
		assertEquals(EnumEdificiosProtos.ACCESO, acceso.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearArchivosTemplariosConRecursosSuficientesyPoblacionSuficiente() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		jugador.incrementarGas(1000);
		jugador.incrementarMineral(1000);
		jugador.construir(EnumEdificiosProtos.ACCESO);
		jugador.construir(EnumEdificiosProtos.PUERTO_ESTELAR);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorArchivosTemplarios()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearArchivosTemplariosConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorArchivosTemplarios()));
	}
		
	@Test
	public void testProtossPuedeCrearAsimiladorConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorAsimilador()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearAsimiladorConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorAsimilador()));
	}
		
	@Test
	public void testProtossCreaAsimilador() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion asimilador = protoss.crearConstruccion(EnumEdificiosProtos.ASIMILADOR);
		
		assertEquals(EnumEdificiosProtos.ASIMILADOR, asimilador.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearNexoMineralConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorNexoMineral()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearNexoMineralConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorNexoMineral()));
	}
		
	@Test
	public void testProtossCreaNexoMineral() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion nexoMineral = protoss.crearConstruccion(EnumEdificiosProtos.NEXO_MINERAL);
		
		assertEquals(EnumEdificiosProtos.NEXO_MINERAL, nexoMineral.getNombre());
	}
	
	@Test
	public void testProtossPuedeCrearPuertoEstelarConRecursosSuficientesyPoblacionSuficiente() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		jugador.incrementarMineral(150);
		jugador.incrementarGas(100);
		jugador.construir(EnumEdificiosProtos.ACCESO);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPuertoEstelarConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorPuertoEstelar()));
	}
	
	@Test
	public void testProtossPuedeCrearPilonConRecursosSuficientesyPoblacionSuficiente() {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		protoss.setDuenio(jugador);
			
		assertEquals(true,protoss.puedoCrearConstruccion(new CreadorPilon()));
	}	
		
	@Test
	public void testProtossNoPuedeCrearPilonConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		jugador.consumirMineral(200);
			
		assertEquals(false,protoss.puedoCrearConstruccion(new CreadorPilon()));
	}
		
	@Test
	public void testProtossCreaPilon() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException {
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS,  Colores.AZUL);
		
		protoss.setDuenio(jugador);
		Construccion pilon = protoss.crearConstruccion(EnumEdificiosProtos.PILON);
		
		assertEquals(EnumEdificiosProtos.PILON, pilon.getNombre());
	}

	@Test
	public void testProtossEmpiezaConSieteConstruccionesDisponibles(){
		CreadorDeEdificiosProtoss protoss = new CreadorDeEdificiosProtoss();
		
		assertEquals(7, protoss.getListaDeConstrucciones().size());
	}
}
	

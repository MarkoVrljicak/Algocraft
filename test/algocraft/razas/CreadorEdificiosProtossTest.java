package algocraft.razas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.Construccion;
import algocraft.exception.DependenciasNoCumplidasException;
import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.CreadorAcceso;
import algocraft.factory.edificiosProtoss.CreadorArchivosTemplarios;
import algocraft.factory.edificiosProtoss.CreadorAsimilador;
import algocraft.factory.edificiosProtoss.CreadorNexoMineral;
import algocraft.factory.edificiosProtoss.CreadorPilon;
import algocraft.factory.edificiosProtoss.CreadorPuertoEstelar;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;

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
	

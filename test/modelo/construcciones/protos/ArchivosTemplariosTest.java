package modelo.construcciones.protos;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosProtoss.CreadorArchivosTemplarios;
import modelo.factory.unidadesProtoss.CreadorAltoTemplario;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.protos.UnidadesProtos;

import org.junit.Test;

public class ArchivosTemplariosTest {
	
	@Test
	public void testArchivosTemplariosInicializaConAltoTemplario() {
		CreadorArchivosTemplarios creador = new CreadorArchivosTemplarios();
		CreadorDeUnidades archivosTemplarios = creador.crearEdificio();
		
		assertEquals(true, archivosTemplarios.tengoUnidad(UnidadesProtos.ALTO_TEMPLARIO));
	}
		
	@Test
	public void testArchivosTemplariosPuedeCrearAltoTemplarioConRecursosSuficientesyPoblacionSuficiente() {
		CreadorArchivosTemplarios creador = new CreadorArchivosTemplarios();
		CreadorDeUnidades archivosTemplarios = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		jugador.incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(true,archivosTemplarios.puedoCrearUnidad(new CreadorAltoTemplario()));
	}	
		
	@Test
	public void testArchivosTemplariosNoPuedeCrearAltoTemplarioConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorArchivosTemplarios creador = new CreadorArchivosTemplarios();
		CreadorDeUnidades archivosTemplarios = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(false,archivosTemplarios.puedoCrearUnidad(new CreadorAltoTemplario()));
	}
		
	@Test
	public void testArchivosTemplariosCreaAltoTemplario() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		CreadorArchivosTemplarios creador = new CreadorArchivosTemplarios();
		CreadorDeUnidades archivosTemplarios = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		
		jugador.incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
		Unidad altoTemplario = archivosTemplarios.crearUnidad(UnidadesProtos.ALTO_TEMPLARIO);
		
		assertEquals(UnidadesProtos.ALTO_TEMPLARIO, altoTemplario.getNombre());
	}
	
}

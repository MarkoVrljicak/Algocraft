package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.exception.PoblacionInsuficienteException;
import algocraft.exception.RecursosNegativosException;
import algocraft.factory.edificiosProtoss.CreadorArchivosTemplarios;
import algocraft.factory.unidadesProtoss.CreadorAltoTemplario;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.UnidadesProtos;

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
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(true,archivosTemplarios.puedoCrearUnidad(new CreadorAltoTemplario()));
	}	
		
	@Test
	public void testArchivosTemplariosNoPuedeCrearAltoTemplarioConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorArchivosTemplarios creador = new CreadorArchivosTemplarios();
		CreadorDeUnidades archivosTemplarios = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(false,archivosTemplarios.puedoCrearUnidad(new CreadorAltoTemplario()));
	}
		
	@Test
	public void testArchivosTemplariosCreaAltoTemplario() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		CreadorArchivosTemplarios creador = new CreadorArchivosTemplarios();
		CreadorDeUnidades archivosTemplarios = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
		Unidad altoTemplario = archivosTemplarios.crearUnidad(UnidadesProtos.ALTO_TEMPLARIO);
		
		assertEquals(UnidadesProtos.ALTO_TEMPLARIO, altoTemplario.getNombre());
	}
	
}

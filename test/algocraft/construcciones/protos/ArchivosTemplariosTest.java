package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.protos.ArchivosTemplarios;
import algocraft.exception.RecursosNegativosException;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.stats.Recurso;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.UnidadesProtos;

public class ArchivosTemplariosTest {
	
	
	private static final Recurso recursosNecesariosAltoTemplario = new Recurso(50,150);
	private static final int poblacionNecesariaAltoTemplario = 2;
	
	@Test
	public void testArchivosTemplariosInicializaConAltoTemplario() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		
		assertEquals(true, archivosTemplarios.tengoUnidad(UnidadesProtos.ALTO_TEMPLARIO));
	}
		
	@Test
	public void testArchivosTemplariosPuedeCrearAltoTemplarioConRecursosSuficientesyPoblacionSuficiente() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(true,archivosTemplarios.puedoCrearUnidad(recursosNecesariosAltoTemplario, poblacionNecesariaAltoTemplario));
	}	
		
	@Test
	public void testArchivosTemplariosNoPuedeCrearAltoTemplarioConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(false,archivosTemplarios.puedoCrearUnidad(recursosNecesariosAltoTemplario, poblacionNecesariaAltoTemplario));
	}
		
	@Test
	public void testArchivosTemplariosCreaAltoTemplario() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		Jugador jugador = new Jugador("Nombre", new Protoss(), Colores.AZUL);
		
		jugador.getRecursos().incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
		Unidad altoTemplario = archivosTemplarios.crearUnidad(UnidadesProtos.ALTO_TEMPLARIO);
		
		assertEquals(UnidadesProtos.ALTO_TEMPLARIO, altoTemplario.getNombre());
	}
	
}

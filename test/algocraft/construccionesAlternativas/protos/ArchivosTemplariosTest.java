package algocraft.construccionesAlternativas.protos;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;

import org.junit.Test;

import razasAlternativas.Protoss;
import stats.Recurso;
import algocraft.exception.RecursosNegativosException;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.protos.UnidadesProtos;

public class ArchivosTemplariosTest {

	private static final UnidadesProtos nombreAltoTemplario= UnidadesProtos.ALTO_TEMPLARIO;
	private static final Recurso recursosNecesariosAltoTemplario = new Recurso(50,150);
	private static final int poblacionNecesariaAltoTemplario = 2;
	
	@Test
	public void testArchivosTemplariosInicializaConAltoTemplario() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		
		assertEquals(true, archivosTemplarios.tengoUnidad(nombreAltoTemplario));
	}
		
	@Test
	public void testArchivosTemplariosPuedeCrearAltoTemplarioConRecursosSuficientesyPoblacionSuficiente() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		jugador.getRecursos().incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(true,archivosTemplarios.puedoCrearUnidad(recursosNecesariosAltoTemplario, poblacionNecesariaAltoTemplario));
	}	
		
	@Test
	public void testArchivosTemplariosNoPuedeCrearAltoTemplarioConRecursosInSuficientesyPoblacionSuficiente() throws RecursosNegativosException {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		archivosTemplarios.setDuenio(jugador);
			
		assertEquals(false,archivosTemplarios.puedoCrearUnidad(recursosNecesariosAltoTemplario, poblacionNecesariaAltoTemplario));
	}
		
	@Test
	public void testArchivosTemplariosCreaAltoTemplario() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		Jugador jugador = new Jugador("Nombre", new Protoss());
		
		jugador.getRecursos().incrementarGas(150);
		archivosTemplarios.setDuenio(jugador);
		Unidad altoTemplario = archivosTemplarios.crearUnidad(nombreAltoTemplario);
		
		assertEquals(nombreAltoTemplario, altoTemplario.getNombre());
	}
	
}

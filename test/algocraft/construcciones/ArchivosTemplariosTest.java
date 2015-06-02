package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.protos.ArchivosTemplarios;
import algocraft.unidades.Unidad;

public class ArchivosTemplariosTest {

	private String nombreAltoTemplario="Alto Templario";
	private Recurso muchosRecursos= new Recurso(999,999);
	private int poblacionSuficiente= 5;

	@Test
	public void testConstruyoArchivosTemplariosYControloSuVidaInicial() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		
		assertEquals(500, archivosTemplarios.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionDeArchivosTemplarios(){
		ArchivosTemplarios archivoTemplario = new ArchivosTemplarios();
		
		assertEquals(9, archivoTemplario.tiempoDeCreacion());
	}
	
	@Test
	public void testArchivoTemplarioInicializaConAltoTemplario() {
		ArchivosTemplarios archivoTemplario = new ArchivosTemplarios();
		
		assertEquals(true, archivoTemplario.tengoUnidad(nombreAltoTemplario));
	}
	
	@Test
	public void testArchivosTemplariosCreaAltoTemplario() {
		ArchivosTemplarios archivoTemplario = new ArchivosTemplarios();
		Unidad altoTemplario = archivoTemplario.crearUnidad( muchosRecursos, nombreAltoTemplario, poblacionSuficiente);
		
		assertEquals(nombreAltoTemplario, altoTemplario.getNombre() );
	}
}

package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.ArchivosTemplarios;

public class ArchivosTemplariosTest {

	@Test
	public void testConstruyoArchivosTemplariosYControloSuVidaInicial() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		
		assertEquals(500, archivosTemplarios.getVida());
	}
	
	@Test
	public void testVeoElTeimpoDeConstruccionDeArchivosTemplarios(){
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		
		assertEquals(9, archivosTemplarios.tiempoDeCreacion());
	}
}

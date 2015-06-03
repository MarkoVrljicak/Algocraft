package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProtossTest {

	private String nombreAcceso = "Acceso";
	private String nombreArchivosTeamplarios = "Archivos Templarios";

	@Test
	public void testProtossInicializaConAcceso() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreAcceso));
	}
	
	@Test
	public void testProtossInicializaConArchivosTemplarios() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreArchivosTeamplarios ));
	}
}

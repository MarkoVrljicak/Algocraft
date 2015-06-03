package razas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProtossTest {

	private String nombreAcceso = "Acceso";

	@Test
	public void testProtossInicializaConAcceso() {
		Protoss protoss = new Protoss();
		
		assertEquals(true, protoss.tengoConstruccion(nombreAcceso));
	}
}

package algocraft.creables;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.ValidadorDeCreaciones;
import algocraft.construcciones.Fabrica;

public class ValidadorDeCreacionesTest {
	public int sinGas = 0;
	public int sinMineral = 0;
	
	@Test
	public void testObtengoNombreDelCreableGuardado() {
		Fabrica fabrica = new Fabrica();
		ValidadorDeCreaciones proxy = new ValidadorDeCreaciones( sinMineral, sinGas, fabrica);
		
		assertEquals("Fabrica", proxy.getNombreCreable());
		
	}

}

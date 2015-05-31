package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.Creable;

public class ConstruccionTest {

	@Test
	public void ConstruccionCreaCopiaDeSiMisma() {
		Construccion construccion = new Refineria();
		Creable refineria = construccion.clonar();
		
		assertEquals(construccion.getNombre() , ((Construccion)refineria).getNombre());		
	}

}

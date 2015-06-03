package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construcciones.terran.Barraca;
import algocraft.construcciones.terran.Refineria;
import algocraft.creables.Creable;

public class ConstruccionTest {

	@Test
	public void testConstruccionCreaCopiaDeSiMisma() {
		Construccion construccion = new Refineria();
		Creable refineria = construccion.clonar();
		
		assertEquals(construccion.getNombre() , ((Construccion)refineria).getNombre());		
	}

	@Test
	public void testConstruccionDisminuyeTiempoDeConstruccionHastaCero() {
		Construccion barraca = new Barraca();
		
		assertEquals(12, barraca.tiempoDeCreacion());
		
		for(int i = 0; i < 13; i++){
			barraca.actualizar();	
		}
		
		assertEquals(0, barraca.tiempoDeCreacion());
	}
}

package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.terran.NaveTransporte;

public class NaveTransporteTest {

	@Test
	public void testCreoNaveTransporteYControloSuVidaInicial() {
		
		NaveTransporte navetransporte = new NaveTransporte();
		
		assertEquals(150, navetransporte.getVida());
	}

}

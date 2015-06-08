package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.Alternativas.terran.NaveTransporte;

public class NaveTransporteTest {

	@Test
	public void testCreoNaveTransporteYControloSuVidaInicial() {
		
		NaveTransporte navetransporte = new NaveTransporte();
		
		assertEquals(150, navetransporte.getVida());
	}
	
	@Test
	public void testNaveTransporteVuela(){
		NaveTransporte nave = new NaveTransporte();
		
		assertEquals(true, nave.soyVolador());
	}

}

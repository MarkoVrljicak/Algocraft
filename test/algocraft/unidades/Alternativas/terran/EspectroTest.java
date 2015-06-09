package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;

import org.junit.Test;


public class EspectroTest {

	@Test
	public void testControloSuVidaInicial() {

		Espectro espectro = new Espectro();
		
		assertEquals(120, espectro.getVida());
	}
	
	@Test
	public void testEspectroEsVolador(){
		Espectro espectro = new Espectro();
		assertEquals(true, espectro.soyVolador());
	}
	
	@Test
	public void testSuminstrosEspectroEs2(){
		Espectro espectro = new Espectro(); 
		
		assertEquals(2,espectro.getSuministros() );
	}

}

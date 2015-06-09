package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MarineTest {

	@Test
	public void testControloSuVidaInicial() {

		Marine marine = new Marine();
		
		assertEquals(40, marine.getVida());
	}
	
	public void testMarineNoEsVolador(){
		Marine marine = new Marine();
		assertEquals(false, marine.soyVolador());
	}
	
	@Test
	public void testSuminstrosMarineEs1(){
		Marine marine = new Marine();
		
		assertEquals(1,marine.getSuministros() );
	}
	
	@Test
	public void testMovimientosMarineEmpiezanEn3(){
		Marine marine = new Marine();
		
		assertEquals(3,marine.getMovimientos().actual() );
	}

}

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
	
	@Test
	public void testSuminstrosNaveTransporteEs2(){
		NaveTransporte nave = new NaveTransporte(); 
		
		assertEquals(2,nave.getSuministros() );
	}
	
	@Test
	public void testNaveTransporteMovimientosEmpiezaEn4(){
		NaveTransporte nave = new NaveTransporte(); 
		
		assertEquals(4,nave.getMovimientos().actual() );
	}

}

package algocraft.unidades.Alternativas.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;



public class NaveTransporteProtosTest {

	@Test
	public void testVerVidaInicialNaveTransporte(){
		
		NaveDeTransporte nave = new NaveDeTransporte();
		
		Assert.assertEquals(80, nave.getVida());
	}
	
	@Test
	public void testNaveTransporteEsVolador(){
		NaveDeTransporte nave = new NaveDeTransporte();
		
		assertEquals(true, nave.soyVolador());
	}
	
	@Test
	public void testSuminstrosNaveTransporteEs2(){
		NaveDeTransporte nave = new NaveDeTransporte(); 
		
		assertEquals(2,nave.getSuministros() );
	}
	
	@Test
	public void testMovimientosNaveTransporteEmpiezaEn4(){
		NaveDeTransporte nave = new NaveDeTransporte(); 
		
		assertEquals(4,nave.getMovimientos().actual() );
	}
}

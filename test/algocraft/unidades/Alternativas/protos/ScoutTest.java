package algocraft.unidades.Alternativas.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.Alternativas.protos.Scout;


public class ScoutTest {

	@Test
	public void testVerVidaInicialScout(){
		
		Scout scout= new Scout();
		
		Assert.assertEquals(150, scout.getVida());
	}
	
	@Test
	public void testScoutEsVolador(){
		Scout scout = new Scout();
		
		assertEquals(true, scout.soyVolador());
	}
	
	@Test
	public void testSuminstrosScoutEs3(){
		Scout scout = new Scout();
		
		assertEquals(3,scout.getSuministros() );
	}
	
	@Test
	public void testMovimientosScoutEmpiezaEn3(){
		Scout scout = new Scout();
		
		assertEquals(3,scout.getMovimientos().actual() );
	}
}

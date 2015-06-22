package modelo.unidades.protos;

import static org.junit.Assert.assertEquals;
import modelo.unidades.protos.Scout;

import org.junit.Assert;
import org.junit.Test;


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
		
		assertEquals(3,scout.getMovimientos() );
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 9;
		Scout scout= new Scout();
		
		assertEquals(true, scout.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			scout.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, scout.enConstruccion());
	}
}

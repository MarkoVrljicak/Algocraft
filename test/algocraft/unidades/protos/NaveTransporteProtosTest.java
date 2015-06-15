package algocraft.unidades.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import algocraft.unidades.protos.NaveDeTransporte;



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
		
		assertEquals(4,nave.getMovimientos() );
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 8;
		NaveDeTransporte naveDeTransporte= new NaveDeTransporte();
		
		assertEquals(true, naveDeTransporte.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			naveDeTransporte.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, naveDeTransporte.enConstruccion());
	}
}

package algocraft.unidades.Alternativas.protos;

import static org.junit.Assert.*;

import org.junit.Test;


public class AltoTemplarioTest {

	@Test
	public void testCreoAltoTemplarioYControloVidaInicial(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(40,altoTemplario.getVida() );
	}
	
	@Test
	public void testAltoTemplarioNoEsVolador(){
		AltoTemplario templario = new AltoTemplario();
		assertEquals(false, templario.soyVolador());
	}
	
	@Test
	public void testSuminstrosAltoTemplarioEs2(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(2,altoTemplario.getSuministros() );
	}
	
	@Test
	public void testMovimientosAltoTemplarioEmpiezanEn3(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(3,altoTemplario.getMovimientos().actual() );
	}
}

package algocraft.unidades.Alternativas.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.Alternativas.protos.Zealot;


public class ZealotTest {

	@Test
	public void testControloSuVidaInicial() {

		Zealot zealot = new Zealot();
		
		assertEquals(100, zealot.getVida());
	}
	
	@Test
	public void testZealotNoEsVolador(){
		Zealot zealot = new Zealot();
		assertEquals(false, zealot.soyVolador());
	}
	
	@Test
	public void testSuminstrosZealotEs2(){
		Zealot zealot = new Zealot();
		
		assertEquals(2,zealot.getSuministros() );
	}
	
	@Test
	public void testMovimientosZealotEmpiezaEn3(){
		Zealot zealot = new Zealot();
		
		assertEquals(3,zealot.getMovimientos().actual() );
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 4;
		Zealot zealot= new Zealot();
		
		assertEquals(true, zealot.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			zealot.iniciarTurno();
		}
		
		assertEquals(false, zealot.enConstruccion());
	}
}

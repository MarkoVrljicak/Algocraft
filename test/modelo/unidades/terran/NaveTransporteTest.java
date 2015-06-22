package modelo.unidades.terran;

import static org.junit.Assert.*;
import modelo.unidades.terran.NaveTransporte;

import org.junit.Test;

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
		
		assertEquals(4,nave.getMovimientos() );
	}

	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 8;
		NaveTransporte naveTransporte= new NaveTransporte();
		
		assertEquals(true, naveTransporte.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			naveTransporte.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, naveTransporte.enConstruccion());
	}
}

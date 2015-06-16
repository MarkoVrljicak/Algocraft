package algocraft.unidades.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.Unidad;
import algocraft.unidades.UnidadMagica;


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
		
		assertEquals(3,altoTemplario.getMovimientos() );
	}
	
	@Test
	public void testAltoTemplarioMuereCon80DeDanio(){
		int danioCausado = 80;
		
		Unidad templario = new AltoTemplario();
		templario.recibirDanio(danioCausado);
		
		assertEquals(true, templario.estoyMuerto());
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 7;
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(true, altoTemplario.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			altoTemplario.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, altoTemplario.enConstruccion());
	}
	
	@Test
	public void testTemplarioEmpiezaCon50DeMagia(){
		UnidadMagica templario = new AltoTemplario();
		
		assertEquals(50, templario.getMagiaActual());
		
	}
	
	@Test
	public void testTemplarioTieneMagiaMaxima200(){
		UnidadMagica templario = new AltoTemplario();
		
		assertEquals(200, templario.getMagiaMaxima());
		
	}
	
	@Test
	public void testTemplarioRegenera15DeMagia(){
		UnidadMagica templario = new AltoTemplario();
		templario.iniciarTurno();
		
		assertEquals(65, templario.getMagiaActual());
		
	}
	

}

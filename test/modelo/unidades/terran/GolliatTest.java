package modelo.unidades.terran;

import static org.junit.Assert.assertEquals;
import modelo.unidades.terran.Golliat;

import org.junit.Test;


public class GolliatTest {

	@Test
	public void testCreoGolliatYControloSuVidaInicial() {
		
		Golliat golliat = new Golliat();
		
		assertEquals(125, golliat.getVida());
	}
	
	public void testGolliatNoEsVolador(){
		Golliat golliat = new Golliat();
		assertEquals(false, golliat.soyVolador());
	}
	
	@Test
	public void testSuminstrosGolliatEs2(){
		Golliat golliat = new Golliat();
		
		assertEquals(2,golliat.getSuministros() );
	}

	@Test
	public void testMovimientosGolliatEmpiezaEn4(){
		Golliat golliat = new Golliat();
		
		assertEquals(4,golliat.getMovimientos() );
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 6;
		Golliat golliat= new Golliat();
		
		assertEquals(true, golliat.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			golliat.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, golliat.enConstruccion());
	}
}

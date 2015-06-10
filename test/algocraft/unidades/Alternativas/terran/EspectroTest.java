package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;
import org.junit.Test;

public class EspectroTest {

	@Test
	public void testControloSuVidaInicial() {

		Espectro espectro = new Espectro();
		
		assertEquals(120, espectro.getVida());
	}
	
	@Test
	public void testEspectroEsVolador(){
		Espectro espectro = new Espectro();
		assertEquals(true, espectro.soyVolador());
	}
	
	@Test
	public void testSuminstrosEspectroEs2(){
		Espectro espectro = new Espectro(); 
		
		assertEquals(2,espectro.getSuministros() );
	}
	
	@Test
	public void testMovimientosEspectroEmpiezaEn3(){
		Espectro espectro = new Espectro();
		
		assertEquals(3,espectro.getMovimientos().actual() );
	}

	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 8;
		Espectro espectro= new Espectro();
		
		assertEquals(true, espectro.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			espectro.iniciarTurno();
		}
		
		assertEquals(false, espectro.enConstruccion());
	}
}

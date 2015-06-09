package algocraft.unidades.Alternativas.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.Alternativas.terran.NaveCiencia;

public class NaveCienciaTest {

	@Test
	public void testCreoNaveCienciaYControloSuVidaInicial() {
		
		NaveCiencia naveciencia = new NaveCiencia();
		
		assertEquals(200, naveciencia.getVida());
	}
	
	@Test
	public void testNaveCienciaVuela(){
		NaveCiencia naveCiencia = new NaveCiencia();
		
		assertEquals(true, naveCiencia.soyVolador());
	}
	
	@Test
	public void testSuminstrosNaveCienciaEs2(){
		NaveCiencia naveCiencia = new NaveCiencia();
		
		assertEquals(2,naveCiencia.getSuministros() );
	}

}

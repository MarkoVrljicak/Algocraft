package algocraft.unidades.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.unidades.terran.NaveCiencia;

public class NaveCienciaTest {

	@Test
	public void testCreoNaveCienciaYControloSuVidaInicial() {
		
		NaveCiencia naveciencia = new NaveCiencia();
		
		assertEquals(200, naveciencia.getVida());
	}

}
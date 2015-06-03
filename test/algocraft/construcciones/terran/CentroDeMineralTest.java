package algocraft.construcciones.terran;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.terran.CentroDeMineral;

public class CentroDeMineralTest {

	@Test
	public void testConstruyoCentroDeMineralYControloSuVidaInicial() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(500, construccion.getVida());
	}

	@Test
	public void testVeoElTiempoDeConstruccionParaCrearCentroDeMineral() {
		Construccion construccion = new CentroDeMineral();
		
		assertEquals(4, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testRecolectoMineralVerificoQueAumente() {
		CentroDeMineral centroMineral= new CentroDeMineral();
		Recurso depositoDeRecursos= new Recurso(0,0);
		
		centroMineral.recolectarMineral(depositoDeRecursos);
		
		assertEquals(10, depositoDeRecursos.obtenerMineral());
	}
	
}

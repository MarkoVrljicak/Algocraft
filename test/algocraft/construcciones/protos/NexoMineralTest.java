package algocraft.construcciones.protos;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.NexoMineral;


public class NexoMineralTest {
	
	@Test
	public void testConstruyoNexoMineralYControloSuVidaInicial() {
		Construccion construccion = new NexoMineral();
		
		assertEquals(250, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearNexoMineral() {
		Construccion construccion = new NexoMineral();
		
		assertEquals(4, construccion.tiempoDeCreacion());
	}
	@Test
	public void testRecolectoMineralVerificoQueAumente(){
		NexoMineral nexo= new NexoMineral();
		Recurso depositoDeRecursos= new Recurso(0,0);
		
		nexo.recolectarMineral(depositoDeRecursos);
		
		assertEquals(10, depositoDeRecursos.obtenerMineral());
	}
}

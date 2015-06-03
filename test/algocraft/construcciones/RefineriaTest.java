package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.terran.Refineria;

public class RefineriaTest {

	@Test
	public void testConstruyoRefineriaYControloSuVidaInicial() {
			Construccion construccion = new Refineria();
			
			assertEquals(750, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearRefineria() {
		Construccion construccion = new Refineria();
		
		assertEquals(6, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testRecolectoGasVerificoQueAumente() {
		Refineria refineria= new Refineria();
		Recurso depositoDeRecursos= new Recurso(0,0);
		
		refineria.recolectarGas(depositoDeRecursos);
		
		assertEquals(10, depositoDeRecursos.obtenerGas());
	}
}

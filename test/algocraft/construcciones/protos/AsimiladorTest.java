package algocraft.construcciones.protos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;
import algocraft.construcciones.Construccion;
import algocraft.construcciones.protos.Asimilador;

public class AsimiladorTest {
	
	@Test
	public void testConstruyoAsimiladorYControloSuVidaInicial() {
			Construccion construccion = new Asimilador();
			
			assertEquals(450, construccion.getVida());
	}
	
	@Test
	public void testVeoElTiempoDeConstruccionParaCrearAsimilador() {
		Construccion construccion = new Asimilador();
		
		assertEquals(6, construccion.tiempoDeCreacion());
	}
	
	@Test
	public void testRecolectoGasVerificoQueAumente() {
		Asimilador asimilador= new Asimilador();
		Recurso depositoDeRecursos= new Recurso(0,0);
		
		asimilador.recolectarGas(depositoDeRecursos);
		
		assertEquals(10, depositoDeRecursos.obtenerGas());
	}
}

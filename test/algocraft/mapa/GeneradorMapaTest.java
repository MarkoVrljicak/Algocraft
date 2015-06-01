package algocraft.mapa;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorMapaTest {
	
	@Test
	public void testGenerarMapaBasicoNoCausaErrores(){
		//test trivial para asegurarse que se corre sin problemas(y cubrir el codigo)
		GeneradorDeMapa generadorMapa= new GeneradorDeMapa();
		
		generadorMapa.generarMapaBasico();
		
		Assert.assertTrue(true);
	}
}
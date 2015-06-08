package algocraft.construccionesAlternativas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stats.Recurso;

public class RecolectorGasTest {

	@Test
	public void testRecoletoGaslVeoSiAumentoEn10(){
		RecolectorGas refineria=new RecolectorGas(
				new EdificioBasico(EdificiosTerran.REFINERIA,750,6));
		Recurso depositoControl=new Recurso(0,0);
		
		refineria.recolectarGas(depositoControl);
		
		assertEquals(10,depositoControl.obtenerGas());
	}
}

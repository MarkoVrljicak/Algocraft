package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.RecolectorGas;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.stats.Recurso;

public class RecolectorGasTest {

	@Test
	public void testRecoletoGaslVeoSiAumentoEn10(){
		RecolectorGas refineria=new RecolectorGas(
				new EdificioBasico(EnumEdificiosTerran.REFINERIA,750,6));
		Recurso depositoControl=new Recurso(0,0);
		
		refineria.recolectarGas(depositoControl);
		
		assertEquals(10,depositoControl.obtenerGas());
	}
}

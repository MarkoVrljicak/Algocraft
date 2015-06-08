package algocraft.construccionesAlternativas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import stats.Recurso;

public class RecolectorMineralTest {

	@Test
	public void testRecoletoMineralVeoSiAumentoEn10(){
		RecolectorMineral centroMineral=new RecolectorMineral(
				new EdificioBasico(EnumEdificiosTerran.CENTRO_DE_MINERALES,500,4));
		Recurso depositoControl=new Recurso(0,0);
		
		centroMineral.recolectarMineral(depositoControl);
		
		assertEquals(10,depositoControl.obtenerMineral());
	}
}

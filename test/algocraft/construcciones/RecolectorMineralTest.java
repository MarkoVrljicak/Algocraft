package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.EnumRazas;

public class RecolectorMineralTest {
	
	private final int mineralInicial = 200;

	@Test
	public void testRecoletoMineralVeoSiAumentoEn10(){
		RecolectorMineral centroMineral=new RecolectorMineral(
				new EdificioBasico(EnumEdificiosTerran.CENTRO_DE_MINERALES,500,4));
		Jugador depositoControl=new Jugador("contorl", EnumRazas.TERRAN , Colores.AZUL);
		
		centroMineral.recolectarMineral(depositoControl);
		
		assertEquals(mineralInicial +10,depositoControl.getMineral());
	}
}

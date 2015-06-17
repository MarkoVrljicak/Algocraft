package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.construcciones.EdificioBasico;
import algocraft.construcciones.RecolectorMineral;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;

public class RecolectorMineralTest {
	
	private final int mineralInicial = 200;

	@Test
	public void testRecoletoMineralVeoSiAumentoEn10(){
		RecolectorMineral centroMineral=new RecolectorMineral(
				new EdificioBasico(EnumEdificiosTerran.CENTRO_DE_MINERALES,500,4));
		Jugador depositoControl=new Jugador("contorl", new Terran() , Colores.AZUL);
		
		centroMineral.recolectarMineral(depositoControl);
		
		assertEquals(mineralInicial +10,depositoControl.getMineral());
	}
}

package modelo.construcciones;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.RecolectorMineral;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;

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

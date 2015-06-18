package algocraft.construcciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.EnumRazas;

public class RecolectorGasTest {

	@Test
	public void testRecoletoGaslVeoSiAumentoEn10(){
		RecolectorGas refineria=new RecolectorGas(
				new EdificioBasico(EnumEdificiosTerran.REFINERIA,750,6));
		Jugador depositoControl=new Jugador("contorl", EnumRazas.TERRAN , Colores.AZUL);
		
		refineria.recolectarGas(depositoControl);
		
		assertEquals(10,depositoControl.getGas());
	}
}

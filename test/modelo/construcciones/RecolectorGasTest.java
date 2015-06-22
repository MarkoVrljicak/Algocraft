package modelo.construcciones;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.EdificioBasico;
import modelo.construcciones.RecolectorGas;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;

import org.junit.Test;

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

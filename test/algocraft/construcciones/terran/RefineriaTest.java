package algocraft.construcciones.terran;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algocraft.construcciones.RecolectorGas;
import algocraft.factory.edificiosTerran.CreadorRefineria;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;


public class RefineriaTest {

	@Test
	public void testRecolectoGas() {
		CreadorRefineria creador = new CreadorRefineria();
		RecolectorGas refineria = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		refineria.recolectarGas(jugador);
		
		assertEquals(10 , jugador.getGas());
	}
	
	@Test
	public void testPasoDeTurnoYRecolectoGas() {
		CreadorRefineria creador = new CreadorRefineria();
		RecolectorGas refineria = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
		
		refineria.setDuenio(jugador);
		refineria.iniciarTurno();
		
		assertEquals(10 , jugador.getGas());
	}
}

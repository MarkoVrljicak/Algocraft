package modelo.construcciones.terran;

import static org.junit.Assert.assertEquals;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosTerran.CreadorFabrica;
import modelo.factory.unidadesTerran.CreadorGolliat;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.Unidad;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class FabricaTest {
	
	@Test
	public void testFabricaInicializaConGolliat() {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		
		assertEquals(true, fabrica.tengoUnidad(UnidadesTerran.GOLLIAT));
	}
		
	@Test
	public void testFabricaPuedeCrearGolliatConRecursosSuficientesyPoblacionSuficiente() {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(100);
		fabrica.setDuenio(jugador);
			
		assertEquals(true,fabrica.puedoCrearUnidad(new CreadorGolliat()));
	}	
		
	@Test
	public void testFabricaNoPuedeCrearGolliatConRecursosInSuficientesyPoblacionSuficiente() 
			throws RecursosNegativosException {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		fabrica.setDuenio(jugador);
			
		assertEquals(false,fabrica.puedoCrearUnidad(new CreadorGolliat()));
	}
		
	@Test
	public void testFabricaCreaGolliat() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		CreadorFabrica creador = new CreadorFabrica();
		CreadorDeUnidades fabrica = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		
		jugador.incrementarGas(100);
		fabrica.setDuenio(jugador);
		Unidad golliat = fabrica.crearUnidad(UnidadesTerran.GOLLIAT);
		
		assertEquals(UnidadesTerran.GOLLIAT, golliat.getNombre());
	}
}


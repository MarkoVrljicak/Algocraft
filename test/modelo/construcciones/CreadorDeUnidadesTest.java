package modelo.construcciones;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.factory.edificiosTerran.CreadorBarraca;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class CreadorDeUnidadesTest {
	//pruebo con una clase hija por ser clase abstracta
		
	private CreadorDeUnidades crearBarracaValida(){
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		barraca.setDuenio(jugador);
		
		return barraca;
	}
	
	@Test
	public void testCreadorEmpiezaSinUnidadEnCreacion(){
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		assertFalse(barraca.unidadEnCreacion());
	}
	
	@Test
	public void testCrearUnidadHaceQueHallaUnidadEnCreacion() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, RecursosNegativosException{
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertTrue(barraca.unidadEnCreacion());
	}
	
	@Test
	public void testCreoUnidadVerificoQueNoEsteTerminada() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, RecursosNegativosException{
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertFalse(barraca.unidadTerminada());
	}
	
	@Test
	public void testCreoUnidadEsperoAQueTermineVerificoQueEsteTerminada() 
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, RecursosNegativosException, PropiedadNoEstaEnJuegoException{
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		barraca.crearUnidad(UnidadesTerran.MARINE);
		for(int turno = 1 ; turno <= 3 ; turno++ )
			barraca.iniciarTurno();
		
		assertTrue(barraca.unidadTerminada());
	}
	
	@Test(expected = MineralInsuficienteException.class)
	public void testIntentarCrearUnidadSinRecursosLanzaException()
			throws MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException, RecursosNegativosException{
		
			CreadorDeUnidades barraca = this.crearBarracaValida();
			
			barraca.crearUnidad(UnidadesTerran.MARINE);
			barraca.crearUnidad(UnidadesTerran.MARINE);
			barraca.crearUnidad(UnidadesTerran.MARINE);
			barraca.crearUnidad(UnidadesTerran.MARINE);
			
			barraca.crearUnidad(UnidadesTerran.MARINE);
			//4 para gastar recursos iniciales, 1 para lanzar exception
	}
}

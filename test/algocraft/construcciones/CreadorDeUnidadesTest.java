package algocraft.construcciones;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.exception.CondicionesInsuficientesException;
import algocraft.exception.GasInsuficienteException;
import algocraft.exception.MineralInsuficienteException;
import algocraft.exception.PoblacionInsuficienteException;
import algocraft.factory.edificiosTerran.CreadorBarraca;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Terran;
import algocraft.unidades.terran.UnidadesTerran;

public class CreadorDeUnidadesTest {
	//pruebo con una clase hija por ser clase abstracta
		
	private CreadorDeUnidades crearBarracaValida(){
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", new Terran(), Colores.AZUL);
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
			throws CondicionesInsuficientesException, MineralInsuficienteException, 
				GasInsuficienteException, PoblacionInsuficienteException{
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertTrue(barraca.unidadEnCreacion());
	}
	
	@Test
	public void testCreoUnidadVerificoQueNoEsteTerminada() 
			throws CondicionesInsuficientesException, MineralInsuficienteException,
				GasInsuficienteException, PoblacionInsuficienteException{
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		barraca.crearUnidad(UnidadesTerran.MARINE);
		
		assertFalse(barraca.unidadTerminada());
	}
	
	@Test
	public void testCreoUnidadEsperoAQueTermineVerificoQueEsteTerminada() 
			throws CondicionesInsuficientesException, MineralInsuficienteException,
				GasInsuficienteException, PoblacionInsuficienteException{
		CreadorDeUnidades barraca = this.crearBarracaValida();
		
		barraca.crearUnidad(UnidadesTerran.MARINE);
		for(int turno = 1 ; turno <= 3 ; turno++ )
			barraca.iniciarTurno();
		
		assertTrue(barraca.unidadTerminada());
	}
	
	@Test(expected = MineralInsuficienteException.class)
	public void testIntentarCrearUnidadSinRecursosLanzaException()
			throws CondicionesInsuficientesException, MineralInsuficienteException,
				GasInsuficienteException, PoblacionInsuficienteException{
		
			CreadorDeUnidades barraca = this.crearBarracaValida();
			
			barraca.crearUnidad(UnidadesTerran.MARINE);
			barraca.crearUnidad(UnidadesTerran.MARINE);
			barraca.crearUnidad(UnidadesTerran.MARINE);
			barraca.crearUnidad(UnidadesTerran.MARINE);
			
			barraca.crearUnidad(UnidadesTerran.MARINE);
			//4 para gastar recursos iniciales, 1 para lanzar exception
	}
}

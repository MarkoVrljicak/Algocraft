package modelo.construcciones;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modelo.exception.EdificioTodaviaEnConstruccionException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.PropiedadNoExisteEnEstaUbicacion;
import modelo.exception.RecursosNegativosException;
import modelo.exception.UnidadIncompletaException;
import modelo.factory.edificiosProtoss.CreadorAcceso;
import modelo.factory.edificiosTerran.CreadorBarraca;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.protos.UnidadesProtos;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class CreadorDeUnidadesTest {
	private static final int tiempoConstruccionBarraca = 12;
	private static final int tiempoConstruccionAcceso = 12;

	//pruebo con una clase hija por ser clase abstracta

	private CreadorDeUnidades crearBarracaValida(){
		CreadorBarraca creador = new CreadorBarraca();
		CreadorDeUnidades barraca = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.TERRAN, Colores.AZUL);
		barraca.setDuenio(jugador);

		return barraca;
	}
	
	private CreadorDeUnidades crearAccesoListo() {
		CreadorAcceso creador = new CreadorAcceso();
		CreadorDeUnidades acceso = creador.crearEdificio();
		Jugador jugador = new Jugador("Nombre", EnumRazas.PROTOSS, Colores.AZUL);
		acceso.setDuenio(jugador);
		for(int turnos = 1 ; turnos<= tiempoConstruccionAcceso ; turnos++)
			try {
				acceso.iniciarTurno();
			} catch (PropiedadNoEstaEnJuegoException e) {
				e.printStackTrace();
			} catch (PropiedadNoExisteEnEstaUbicacion e) {
				e.printStackTrace();
			}

		return acceso;
	}


	private CreadorDeUnidades crearBarracaLista(){
		CreadorDeUnidades barraca = crearBarracaValida();
		for(int turnos = 1 ; turnos<= tiempoConstruccionBarraca ; turnos++)
			try {
				barraca.iniciarTurno();
			} catch (PropiedadNoEstaEnJuegoException | PropiedadNoExisteEnEstaUbicacion e) {
				e.printStackTrace();
			}
		return barraca;
	}

	@Test
	public void testCreadorEmpiezaSinUnidadEnCreacion(){
		CreadorDeUnidades barraca = this.crearBarracaLista();

		assertFalse(barraca.unidadEnCreacion());
	}

	@Test
	public void testCrearUnidadHaceQueHallaUnidadEnCreacion() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException{
		CreadorDeUnidades barraca = this.crearBarracaLista();

		barraca.crearUnidad(UnidadesTerran.MARINE);

		assertTrue(barraca.unidadEnCreacion());
	}

	@Test
	public void testCreoUnidadVerificoQueNoEsteTerminada() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException{
		CreadorDeUnidades barraca = this.crearBarracaLista();

		barraca.crearUnidad(UnidadesTerran.MARINE);

		assertFalse(barraca.unidadTerminada());
	}

	@Test
	public void testCreoUnidadEsperoAQueTermineVerificoQueEsteTerminada() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException,
			PropiedadNoEstaEnJuegoException, EdificioTodaviaEnConstruccionException{
		CreadorDeUnidades barraca = this.crearBarracaLista();

		barraca.crearUnidad(UnidadesTerran.MARINE);
		for(int turno = 1 ; turno <= 3 ; turno++ )
			try {
				barraca.iniciarTurno();
			} catch (PropiedadNoExisteEnEstaUbicacion e) {
				e.printStackTrace();
			}

		assertTrue(barraca.unidadTerminada());
	}

	@Test(expected = MineralInsuficienteException.class)
	public void testIntentarCrearUnidadSinMineralLanzaException()
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException{

		CreadorDeUnidades barraca = this.crearBarracaLista();

		barraca.crearUnidad(UnidadesTerran.MARINE);
		barraca.crearUnidad(UnidadesTerran.MARINE);
		barraca.crearUnidad(UnidadesTerran.MARINE);
		barraca.crearUnidad(UnidadesTerran.MARINE);

		barraca.crearUnidad(UnidadesTerran.MARINE);
		//4 para gastar recursos iniciales, 1 para lanzar exception
	}
	
	@Test(expected = GasInsuficienteException.class)
	public void testIntentarCrearUnidadSinGasLanzaException()
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException{

		CreadorDeUnidades acceso = this.crearAccesoListo();

		acceso.crearUnidad(UnidadesProtos.DRAGON);
	}
	
	@Test(expected = EdificioTodaviaEnConstruccionException.class)
	public void testIntentarCrearUnidadMientrasCreadorEstaEnConstruccionNoFunicona() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, EdificioTodaviaEnConstruccionException{
		
		CreadorDeUnidades barraca = this.crearBarracaValida();
		assertTrue(barraca.enConstruccion());
		
		barraca.crearUnidad(UnidadesTerran.MARINE);			
	}
	
	@Test(expected = UnidadIncompletaException.class)
	public void testIntentarSacarUnidadAntesDeQueEsteTerminadaLanzaException() 
			throws MineralInsuficienteException, GasInsuficienteException, 
			PoblacionInsuficienteException, RecursosNegativosException, 
			EdificioTodaviaEnConstruccionException, UnidadIncompletaException{
		
		CreadorDeUnidades barraca = this.crearBarracaLista();
		barraca.crearUnidad(UnidadesTerran.MARINE);	
		
		barraca.obtenerUnidadCreada();
	}
}

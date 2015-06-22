package modelo;

import static org.junit.Assert.assertEquals;
import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PoblacionInsuficienteException;
import modelo.exception.UnidadIncompletaException;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.jugador.Jugador;
import modelo.razas.EnumRazas;
import modelo.unidades.UnidadAtacante;
import modelo.unidades.protos.Dragon;
import modelo.unidades.terran.UnidadesTerran;

import org.junit.Test;

public class IntegracionesJugadorTest {
	
	private static final int topePoblacion = 200;
	private static final int edificiosParaLegarATopePoblacion = (topePoblacion-5)/ 5;
	private static final int tiempoCreacionUnMarine = 3;
	private static final int tiempoCreacionUnPilon = 6;
	
	private Jugador nuevoJugadorTerran() {
		Jugador jugador= new Jugador("Fernando De La Rua", EnumRazas.TERRAN, Colores.AZUL);
		return jugador;
	}
	
	private Jugador crearJugadorProtos() {
		Jugador jugador= new Jugador("Fernando De La Rua", EnumRazas.PROTOSS, Colores.AZUL);
		return jugador;
	}
	
	public void iniciarJugadorTerranConRecursos(Jugador jugador) 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		final int turnosSuficientesParaQueSobrenRecursos = 200;
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);
		jugador.construir(EnumEdificiosTerran.REFINERIA);
		//espero a que se construyan y recolecten recursos de mas
		for(int turno=1; turno<= turnosSuficientesParaQueSobrenRecursos  ; turno++){
			jugador.iniciarTurno();
		}
	}
	
	public void iniciarJugadorProtossConRecursos(Jugador jugador) 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		final int turnosSuficientesParaQueSobrenRecursos = 200;
		//construyo edificios para acumular recursos 
		jugador.construir(EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.NEXO_MINERAL);
		jugador.construir(EnumEdificiosProtos.ASIMILADOR);
		//espero a que se construyan y recolecten recursos de mas
		for(int turno=1; turno<= turnosSuficientesParaQueSobrenRecursos  ; turno++){
			jugador.iniciarTurno();
		}
	}
	
	@Test
	public void testActualizarConCentroDeMineralAumentaLosRecursosDelJugador() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		Jugador jugador = nuevoJugadorTerran();
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);

		jugador.iniciarTurno();
		//160 por que es 200 iniciales -50 del centro mineral +10 de la recoleccion
		assertEquals(160,jugador.getMineral());
	}

	@Test
	public void testActualizarConRefineriaAumentaLosRecursosDelJugador() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		Jugador jugador = nuevoJugadorTerran();
		jugador.construir(EnumEdificiosTerran.REFINERIA);

		jugador.iniciarTurno();

		assertEquals(10,jugador.getGas());
	}


	@Test
	public void testConstruirReduceRecursos() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		Jugador jugador = nuevoJugadorTerran();

		//cuesta 100 mineral
		jugador.construir(EnumEdificiosTerran.REFINERIA);

		//200 iniciales - 100 coste refineria
		assertEquals(100,jugador.getMineral());
	}	


	@Test
	public void testConstruyoPilonEsperoAQueSeConstruyaMiroPoblacion()
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		Jugador jugador = crearJugadorProtos();

		jugador.construir(EnumEdificiosProtos.PILON);
		//espero a que se construya
		for(int i=1; i<=tiempoCreacionUnPilon ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(10, jugador.getPoblacionMaxima() );
	}

	@Test
	public void testLlevoPoblacionMaximaAlTopeYVerifico() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		Jugador jugador = crearJugadorProtos();
		this.iniciarJugadorProtossConRecursos(jugador);
		
		//construyo pilones exactos para llegar a 200(39*5=195 +5 iniciales)
		for(int i=1; i<=edificiosParaLegarATopePoblacion ; i++){
			jugador.construir(EnumEdificiosProtos.PILON);
		}
		//espero a que se construyan
		for(int i=1; i<=tiempoCreacionUnPilon ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(topePoblacion, jugador.getPoblacionMaxima() );
	}


	@Test
	public void testSuperoTopePoblacionMaximaVerificoQueSigaEnTope() 
			throws MineralInsuficienteException, GasInsuficienteException, DependenciasNoCumplidasException{
		Jugador jugador = crearJugadorProtos();
		this.iniciarJugadorProtossConRecursos(jugador);

		//creo muchos pilones
		for(int i=1; i<= edificiosParaLegarATopePoblacion+1 ; i++){
			jugador.construir(EnumEdificiosProtos.PILON);
		}
		//espero a que se construyan
		for(int i=1; i<=tiempoCreacionUnPilon ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(topePoblacion, jugador.getPoblacionMaxima() );
	}
	
	@Test
	public void testCrearUnidadesNoAumentaPoblacionSiNoEspero() 
			throws DependenciasNoCumplidasException, MineralInsuficienteException,
				GasInsuficienteException, PoblacionInsuficienteException {
		Jugador jugador = nuevoJugadorTerran();
		this.iniciarJugadorTerranConRecursos(jugador);
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(EnumEdificiosTerran.BARRACA);

		//creo unidad
		jugador.crearUnidad( UnidadesTerran.MARINE, barraca);
			
		assertEquals( 0 , jugador.getPoblacionActual() );
	}

	@Test
	public void testCrearUnidadesYEsperarASuCreacionAumentaPoblacion() 
			throws DependenciasNoCumplidasException, MineralInsuficienteException,
				GasInsuficienteException, PoblacionInsuficienteException {
		Jugador jugador = nuevoJugadorTerran();
		this.iniciarJugadorTerranConRecursos(jugador);
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(EnumEdificiosTerran.BARRACA);

		//creo unidad
		jugador.crearUnidad( UnidadesTerran.MARINE, barraca);
		//espero a que se cree
		for(int i=1; i<=tiempoCreacionUnMarine ; i++){
			jugador.iniciarTurno();
		}
	
	
		assertEquals( 1 , jugador.getPoblacionActual() );
	}

	@Test(expected = PoblacionInsuficienteException.class)
	public void testNoSePuedeCrearUnidadesCuandoPoblacionEstaAlMaximo() 
			throws UnidadIncompletaException, DependenciasNoCumplidasException,
				MineralInsuficienteException, GasInsuficienteException, PoblacionInsuficienteException {
		Jugador jugador =nuevoJugadorTerran();
		this.iniciarJugadorTerranConRecursos(jugador);
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(EnumEdificiosTerran.BARRACA);
		//creo 5 marines
		for(int i = 1 ; i <= 5 ; i++ ){
			jugador.crearUnidad( UnidadesTerran.MARINE, barraca);
			for(int turno=1; turno<=tiempoCreacionUnMarine ; turno++){
				jugador.iniciarTurno();
			}
			barraca.obtenerUnidadCreada();
		}
		
		
		
		assertEquals( 5 , jugador.getPoblacionMaxima() );//verifico poblacion maxima
		assertEquals( 5 , jugador.getPoblacionActual() );//verifico poblacion maxima alcanzada
		
		jugador.crearUnidad( UnidadesTerran.MARINE, barraca) ;
	}

	@Test
	public void testMatarUnidadesdisminuyePoblacion() 
			throws DependenciasNoCumplidasException, MineralInsuficienteException,
				GasInsuficienteException, PoblacionInsuficienteException {
		Jugador jugador = nuevoJugadorTerran();
		this.iniciarJugadorTerranConRecursos(jugador);
		
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(EnumEdificiosTerran.BARRACA);
		
		//creo unidad
		Daniable marine = jugador.crearUnidad( UnidadesTerran.MARINE, barraca);
		for(int i=1; i<=tiempoCreacionUnMarine ; i++){
			jugador.iniciarTurno();
		}
		
		assertEquals( 1 , jugador.getPoblacionActual() );//verifico aumento poblacion
		
		//mato unidad
		UnidadAtacante dragon = new Dragon();
		dragon.atacar(marine, 1);
		dragon.iniciarTurno();
		dragon.atacar(marine, 1);

		assertEquals(true, marine.estoyMuerto());//verifico marine muerto
		
		jugador.iniciarTurno();//para limpiar muertos de los datos
		
		assertEquals( 0 , jugador.getPoblacionActual() );//verifico disminucion poblacion
	}
}

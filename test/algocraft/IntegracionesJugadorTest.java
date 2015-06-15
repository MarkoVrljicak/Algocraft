package algocraft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.Interfaces.Daniable;
import algocraft.construcciones.CreadorDeUnidades;
import algocraft.exception.UnidadIncompletaException;
import algocraft.factory.edificiosProtoss.EnumEdificiosProtos;
import algocraft.factory.edificiosTerran.EnumEdificiosTerran;
import algocraft.jugador.Colores;
import algocraft.jugador.Jugador;
import algocraft.razas.Protoss;
import algocraft.razas.Terran;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.Dragon;
import algocraft.unidades.terran.UnidadesTerran;

public class IntegracionesJugadorTest {
	
	private static final int topePoblacion = 200;
	private static final int edificiosParaLegarATopePoblacion = (topePoblacion-5)/ 5;
	private static final int tiempoCreacionUnMarine = 3;
	private static final int tiempoCreacionUnPilon = 6;
	
	
	public void iniciarJugadorTerranConRecursos(Jugador jugador){
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
	
	public void iniciarJugadorProtossConRecursos(Jugador jugador){
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
	public void testActualizarConCentroDeMineralAumentaLosRecursosDelJugador(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		jugador.construir(EnumEdificiosTerran.CENTRO_DE_MINERALES);

		jugador.iniciarTurno();
		//160 por que es 200 iniciales -50 del centro mineral +10 de la recoleccion
		assertEquals(160,jugador.getRecursos().obtenerMineral());
	}


	@Test
	public void testActualizarConRefineriaAumentaLosRecursosDelJugador(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);
		jugador.construir(EnumEdificiosTerran.REFINERIA);

		jugador.iniciarTurno();

		assertEquals(10,jugador.getRecursos().obtenerGas());
	}


	@Test
	public void testConstruirReduceRecursos(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), Colores.AZUL);

		//cuesta 100 mineral
		jugador.construir(EnumEdificiosTerran.REFINERIA);

		//200 iniciales - 100 coste refineria
		assertEquals(100,jugador.getRecursos().obtenerMineral());
	}	


	@Test
	public void testConstruyoPilonEsperoAQueSeConstruyaMiroPoblacion(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), Colores.AZUL);

		jugador.construir(EnumEdificiosProtos.PILON);
		//espero a que se construya
		for(int i=1; i<=tiempoCreacionUnPilon ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(10, jugador.getPoblacionMaxima() );
	}


	@Test
	public void testLlevoPoblacionMaximaAlTopeYVerifico(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), Colores.AZUL);
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
	public void testSuperoTopePoblacionMaximaVerificoQueSigaEnTope(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), Colores.AZUL);
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
	public void testCrearUnidadesNoAumentaPoblacionSiNoEspero() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
		this.iniciarJugadorTerranConRecursos(jugador);
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(EnumEdificiosTerran.BARRACA);

		//creo unidad
		jugador.crearUnidad( UnidadesTerran.MARINE, barraca);
			
		assertEquals( 0 , jugador.getPoblacionActual() );
	}

	@Test
	public void testCrearUnidadesYEsperarASuCreacionAumentaPoblacion() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
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

	@Test
	public void testNoSePuedeCrearUnidadesCuandoPoblacionEstaAlMaximo() 
			throws UnidadIncompletaException {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
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
		assertEquals( null , jugador.crearUnidad( UnidadesTerran.MARINE, barraca) );//verifico que no pueda crear
	}

	@Test
	public void testMatarUnidadesdisminuyePoblacion() {
		Jugador jugador = new Jugador("pepe", new Terran(), Colores.AZUL);
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
		Unidad dragon = new Dragon();
		dragon.atacar(marine, 1);
		dragon.atacar(marine, 1);

		assertEquals(true, marine.estoyMuerto());//verifico marine muerto
		
		jugador.iniciarTurno();//para limpiar muertos de los datos
		
		assertEquals( 0 , jugador.getPoblacionActual() );//verifico disminucion poblacion
	}
}

package algocraft;

import static org.junit.Assert.assertEquals;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import Interfaces.Daniable;
import algocraft.construccionesAlternativas.CreadorDeUnidades;
import algocraft.construccionesAlternativas.EnumEdificios;
import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.Unidades;
import algocraft.unidades.Alternativas.protos.Dragon;
import algocraft.unidades.Alternativas.terran.UnidadesTerran;
import razasAlternativas.Protoss;
import razasAlternativas.Terran;

public class IntegracionesJugadorTest {

	Colores colorAzul = Colores.AZUL;
	private static final EnumEdificiosTerran nombreCentroDeMineral = EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;
	private static final EnumEdificiosProtos nombrePilon = EnumEdificiosProtos.PILON;
	private static final EnumEdificiosProtos nombreNexo = EnumEdificiosProtos.NEXO_MINERAL;
	private static final EnumEdificios nombreBarraca = EnumEdificiosTerran.BARRACA;
	private static final Unidades nombreMarine = UnidadesTerran.MARINE;


	@Test
	public void testActualizarConCentroDeMineralAumentaLosRecursosDelJugador(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), colorAzul);
		jugador.construir(nombreCentroDeMineral);

		jugador.iniciarTurno();
		//160 por que es 200 iniciales -50 del centro mineral +10 de la recoleccion
		assertEquals(160,jugador.getRecursos().obtenerMineral());
	}


	@Test
	public void testActualizarConRefineriaAumentaLosRecursosDelJugador(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), colorAzul);
		jugador.construir(nombreRefineria);

		jugador.iniciarTurno();

		assertEquals(10,jugador.getRecursos().obtenerGas());
	}


	@Test
	public void testConstruirReduceRecursos(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), colorAzul);

		//cuesta 100 mineral
		jugador.construir(nombreRefineria);

		//200 iniciales - 100 coste refineria
		assertEquals(100,jugador.getRecursos().obtenerMineral());
	}	


	@Test
	public void testConstruyoPilonEsperoAQueSeConstruyaMiroPoblacion(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), colorAzul);

		jugador.construir(nombrePilon);
		//espero a que se construya
		for(int i=1; i<=6 ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(10, jugador.getPoblacionMaxima() );
	}


	@Test
	public void testLlevoPoblacionMaximaAlTopeYVerifico(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), colorAzul);
		//construyo edificios para acumular recursos 
		for(int i = 1 ; i <= 4 ; i++ ){
			jugador.construir(nombreNexo);
		}
		//espero a que se construyan(4) y recolecten recursos de mas(200)
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//construyo pilones exactos para llegar a 200(39*5=195 +5 iniciales)
		for(int i=1; i<=39 ; i++){
			jugador.construir(nombrePilon);
		}
		//espero a que se construyan
		for(int i=1; i<=6 ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(200, jugador.getPoblacionMaxima() );
	}


	@Test
	public void testSuperoTopePoblacionMaximaVerificoQueSigaEnTope(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), colorAzul);
		//construyo edificios para acumular recursos 
		for(int i = 1 ; i <= 4 ; i++ ){
			jugador.construir(nombreNexo);
		}
		//espero a que se construyan(4) y recolecten recursos de mas(200)
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}

		//creo muchos pilones
		for(int i=1; i<=50 ; i++){
			jugador.construir(nombrePilon);
		}
		//espero a que se construyan
		for(int i=1; i<=6 ; i++){
			jugador.iniciarTurno();
		}

		assertEquals(200, jugador.getPoblacionMaxima() );
	}

	@Test
	public void testCrearUnidadesAumentaPoblacion() {
		Jugador jugador = new Jugador("pepe", new Terran(), colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(nombreBarraca);

		//creo unidad
		jugador.crearUnidad(nombreMarine, barraca);


		assertEquals( 1 , jugador.getPoblacionActual() );
	}

	@Test
	public void testNoSePuedeCrearUnidadesCuandoPoblacionEstaAlMaximo() {
		Jugador jugador = new Jugador("pepe", new Terran(), colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(nombreBarraca);
		//creo 5 marines
		for(int i = 1 ; i <= 5 ; i++ ){
			jugador.crearUnidad(nombreMarine, barraca);
		}

		assertEquals( 5 , jugador.getPoblacionMaxima() );//verifico poblacion maxima
		assertEquals( 5 , jugador.getPoblacionActual() );//verifico poblacion maxima alcanzada
		assertEquals( null , jugador.crearUnidad(nombreMarine, barraca) );//verifico que no pueda crear
	}

	@Test
	public void testMatarUnidadesdisminuyePoblacion() {
		Jugador jugador = new Jugador("pepe", new Terran(), colorAzul);
		//construyo edificios para acumular recursos 
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreCentroDeMineral);
		jugador.construir(nombreRefineria);
		//espero a que se construyan y recolecten recursos de mas
		for(int i=1; i<= 200  ; i++){
			jugador.iniciarTurno();
		}
		//creo edificios para unidades
		CreadorDeUnidades barraca = (CreadorDeUnidades) jugador.construir(nombreBarraca);
		
		//creo unidad
		Daniable marine = jugador.crearUnidad(nombreMarine, barraca);
		
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

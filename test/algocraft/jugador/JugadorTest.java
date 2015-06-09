package algocraft.jugador;

import static org.junit.Assert.*;

import org.junit.Test;

import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import razasAlternativas.EnumRazas;
import razasAlternativas.Protoss;
import razasAlternativas.Terran;
import jugador.Jugador;

public class JugadorTest {
	private static final EnumRazas nombreTerran = EnumRazas.TERRAN;;
	private static final EnumEdificiosTerran nombreBarraca = EnumEdificiosTerran.BARRACA;
	private static final EnumEdificiosTerran nombreCentroDeMineral = EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;
	private static final EnumEdificiosProtos nombrePilon = EnumEdificiosProtos.PILON;
	
	@Test
	public void jugadorTerranEmpiezaConPoblacionCero() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(0, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void jugadorObtieneNombreDeRaza() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(nombreTerran, jugadorTerran.getRaza());
	}
	
	@Test
	public void jugadorTerranTieneSeisConstruccionesDisponibles() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(7, jugadorTerran.getConstruccionesDisponibles().size());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon200DeMineral() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(200, jugadorTerran.getRecursos().obtenerMineral());
	}
	
	@Test
	public void jugadorTerranEmpiezaCon0DeGas() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(0, jugadorTerran.getRecursos().obtenerGas());
	}
	
	@Test
	public void jugadorTerranEmpiezaSinEdificios() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(0, jugadorTerran.cantidadConstrucciones());
	}
	
	@Test
	public void jugadorTerranPuedeCrearBarracaConRecursosIniciales() {
		Jugador jugadorTerran = new Jugador("Fernando De La Rua", new Terran());
		jugadorTerran.construir(nombreBarraca);
		
		assertEquals(1, jugadorTerran.cantidadConstrucciones());
	}
	
	//prueba integracion recoleccion recursos con centro mineral
	@Test
	public void testActualizarConCentroDeMineralAumentaLosRecursosDelJugador(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran());
		jugador.construir(nombreCentroDeMineral);
		
		jugador.pasarTurno();
		
		assertEquals(210,jugador.getRecursos().obtenerMineral());
	}
	
	//prueba integracion recoleccion recursos con refineria
	@Test
	public void testActualizarConRefineriaAumentaLosRecursosDelJugador(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran());
		jugador.construir(nombreRefineria);
		
		jugador.pasarTurno();
		
		assertEquals(10,jugador.getRecursos().obtenerGas());
	}
	
	
	@Test
	public void testJugadorEmpiezaConPoblacionMaximaCinco(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Terran());
		
		assertEquals(5,jugador.getPoblacionMaxima() );
	}
	
	//prueba integracion poblacion con pilon
	@Test
	public void testConstruyoPilonEsperoAQueSeConstruyaMiroPoblacion(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss());
	
		jugador.construir(nombrePilon);
		//espero a que se construya
		for(int i=1; i<=6 ; i++){
			jugador.pasarTurno();
		}
	
		assertEquals(10, jugador.getPoblacionMaxima() );
	}
	
	@Test
	public void testLlevoPoblacionMaximaAlTopeYVerifico(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss());
		//construyo pilones exactos para llegar a 200(39*5=195 +5 iniciales)
		for(int i=1; i<=39 ; i++){
		jugador.construir(nombrePilon);
		}
		//espero a que se construyan
		for(int i=1; i<=6 ; i++){
			jugador.pasarTurno();
		}
	
		assertEquals(200, jugador.getPoblacionMaxima() );
	}
	
	@Test
	public void testSuperoTopePoblacionMaximaVerificoQueSigaEnTope(){
		Jugador jugador= new Jugador("Fernando De La Rua", new Protoss());
		//construyo pilones exactos para llegar a 200(39*5=195 +5 iniciales)
		for(int i=1; i<=50 ; i++){
		jugador.construir(nombrePilon);
		}
		//espero a que se construyan
		for(int i=1; i<=6 ; i++){
			jugador.pasarTurno();
		}
	
		assertEquals(200, jugador.getPoblacionMaxima() );
	}
	
}

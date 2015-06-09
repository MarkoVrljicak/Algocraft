package algocraft;

import static org.junit.Assert.assertEquals;
import jugador.Colores;
import jugador.Jugador;

import org.junit.Test;

import algocraft.construccionesAlternativas.protos.EnumEdificiosProtos;
import algocraft.construccionesAlternativas.terran.EnumEdificiosTerran;
import razasAlternativas.Protoss;
import razasAlternativas.Terran;

public class IntegracionesJugadorTest {
	
	Colores colorAzul = Colores.AZUL;
	private static final EnumEdificiosTerran nombreCentroDeMineral = EnumEdificiosTerran.CENTRO_DE_MINERALES;
	private static final EnumEdificiosTerran nombreRefineria = EnumEdificiosTerran.REFINERIA;
	private static final EnumEdificiosProtos nombrePilon = EnumEdificiosProtos.PILON;
	private static final EnumEdificiosProtos nombreNexo = EnumEdificiosProtos.NEXO_MINERAL;

	
		@Test
		public void testActualizarConCentroDeMineralAumentaLosRecursosDelJugador(){
			Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), colorAzul);
			jugador.construir(nombreCentroDeMineral);
			
			jugador.pasarTurno();
			//160 por que es 200 iniciales -50 del centro mineral +10 de la recoleccion
			assertEquals(160,jugador.getRecursos().obtenerMineral());
		}
		
		
		@Test
		public void testActualizarConRefineriaAumentaLosRecursosDelJugador(){
			Jugador jugador= new Jugador("Fernando De La Rua", new Terran(), colorAzul);
			jugador.construir(nombreRefineria);
			
			jugador.pasarTurno();
			
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
				jugador.pasarTurno();
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
				jugador.pasarTurno();
			}
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
			Jugador jugador= new Jugador("Fernando De La Rua", new Protoss(), colorAzul);
			//construyo edificios para acumular recursos 
			for(int i = 1 ; i <= 4 ; i++ ){
				jugador.construir(nombreNexo);
			}
			//espero a que se construyan(4) y recolecten recursos de mas(200)
			for(int i=1; i<= 200  ; i++){
				jugador.pasarTurno();
			}
			
			//creo muchos pilones
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

package algocraft.unidades.protos;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;
import algocraft.unidades.UnidadMagica;


public class AltoTemplarioTest {

	@Test
	public void testCreoAltoTemplarioYControloVidaInicial(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(40,altoTemplario.getVida() );
	}
	
	@Test
	public void testAltoTemplarioNoEsVolador(){
		AltoTemplario templario = new AltoTemplario();
		assertEquals(false, templario.soyVolador());
	}
	
	@Test
	public void testSuminstrosAltoTemplarioEs2(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(2,altoTemplario.getSuministros() );
	}
	
	@Test
	public void testMovimientosAltoTemplarioEmpiezanEn3(){
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(3,altoTemplario.getMovimientos() );
	}
	
	@Test
	public void testAltoTemplarioMuereCon80DeDanio(){
		int danioCausado = 80;
		
		Unidad templario = new AltoTemplario();
		templario.recibirDanio(danioCausado);
		
		assertEquals(true, templario.estoyMuerto());
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 7;
		AltoTemplario altoTemplario= new AltoTemplario();
		
		assertEquals(true, altoTemplario.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			altoTemplario.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, altoTemplario.enConstruccion());
	}
	
	@Test
	public void testTemplarioEmpiezaCon50DeMagia(){
		UnidadMagica templario = new AltoTemplario();
		
		assertEquals(50, templario.getMagiaActual());
		
	}
	
	@Test
	public void testTemplarioTieneMagiaMaxima200(){
		UnidadMagica templario = new AltoTemplario();
		
		assertEquals(200, templario.getMagiaMaxima());
		
	}
	
	@Test
	public void testTemplarioRegenera15DeMagia(){
		UnidadMagica templario = new AltoTemplario();
		templario.iniciarTurno();
		
		assertEquals(65, templario.getMagiaActual());
		
	}
	
	@Test
	public void testTemplarioClonaUnidad() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		Unidad original = new Zealot();
		AltoTemplario templario = new AltoTemplario();
		Coordenada ubicacion = new Coordenada(5,5);
		mapa.almacenar(original, ubicacion);
		
		int variosTurnos = 20;
		for(int i=0; i<variosTurnos; i++){
			templario.iniciarTurno(); //para llenar magia
		}
		
		templario.alucinacion(original, mapa.obtenerRadioDeCasilleros(2, ubicacion));
		
		int alucinacionesEncontradas = 0;
		
		Iterator<Terreno> iterMapa = mapa.iterator();
		while(iterMapa.hasNext()){
			Terreno terreno = iterMapa.next();
			Unidad unidad = (Unidad) terreno.getContenidoSuelo();
			if(unidad != null && unidad.getNombre() == UnidadesProtos.ALUCINACION){
				alucinacionesEncontradas++;
			}
		}
		
		assertEquals(2, alucinacionesEncontradas);
	}
	
	@Test
	public void testTemplarioNoClonaUnidadSinMagiaSuficiente3() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		Unidad original = new Zealot();
		AltoTemplario templario = new AltoTemplario();
		Coordenada ubicacion = new Coordenada(5,5);
		mapa.almacenar(original, ubicacion);
		
		templario.alucinacion(original, mapa.obtenerRadioDeCasilleros(2, ubicacion));
		
		int alucinacionesEncontradas = 0;
		
		Iterator<Terreno> iterMapa = mapa.iterator();
		while(iterMapa.hasNext()){
			Terreno terreno = iterMapa.next();
			Unidad unidad = (Unidad) terreno.getContenidoSuelo();
			if(unidad != null && unidad.getNombre() == UnidadesProtos.ALUCINACION){
				alucinacionesEncontradas++;
			}
		}
		
		assertEquals(0, alucinacionesEncontradas);
	}
	
	@Test
	public void testAlucinacionGastaXMagia() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		Unidad original = new Zealot();
		AltoTemplario templario = new AltoTemplario();
		Coordenada ubicacion = new Coordenada(5,5);
		mapa.almacenar(original, ubicacion);
		
		int variosTurnos = 20;
		for(int i=0; i<variosTurnos; i++){
			templario.iniciarTurno(); //para llenar magia
		}
		
		int magiaOriginal = templario.getMagiaActual();
		
		templario.alucinacion(original, mapa.obtenerRadioDeCasilleros(2, ubicacion));
		
		assertEquals(templario.getMagiaActual(), magiaOriginal - 100);
	}
	
	

}

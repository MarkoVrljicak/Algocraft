package algocraft.unidades.protos;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.mapa.terrenos.Terreno;
import algocraft.unidades.Unidad;
import algocraft.unidades.UnidadMagica;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;


public class AltoTemplarioTest {
	
	public void pasarMuchosTurnos(AltoTemplario templario){
		//para llenar magia
		for(int i = 0; i<20; i++){
			templario.iniciarTurno();
		}
	}

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
		
		pasarMuchosTurnos(templario);
		
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
	public void testTemplarioNoClonaUnidadSinMagiaSuficiente() throws DestinoInvalidoException, FueraDeLimitesException{
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
	public void testAlucinacionGasta100Magia() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		Unidad original = new Zealot();
		AltoTemplario templario = new AltoTemplario();
		Coordenada ubicacion = new Coordenada(5,5);
		mapa.almacenar(original, ubicacion);
		
		pasarMuchosTurnos(templario);
		
		int magiaOriginal = templario.getMagiaActual();
		
		templario.alucinacion(original, mapa.obtenerRadioDeCasilleros(2, ubicacion));
		
		assertEquals(templario.getMagiaActual(), magiaOriginal - 100);
	}
	
	@Test
	public void testTormentaPsionicaDaniaUnidad() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		AltoTemplario templario = new AltoTemplario();
		pasarMuchosTurnos(templario);
		
		Unidad otraUnidad = new Marine();
		Coordenada posicion =  new Coordenada(5,5);
		mapa.almacenar(otraUnidad, posicion);
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, posicion);
		
		int vidaOriginal = otraUnidad.getVida();
		
		templario.tormentaPsionica(area);
		
		assertEquals(true, otraUnidad.getVida() < vidaOriginal);
	}
	
	@Test
	public void testTormentaPsionicaHace100DeDanioLaPrimeraVuelta() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		AltoTemplario templario = new AltoTemplario();
		Unidad otraUnidad = new NaveCiencia();
		
		pasarMuchosTurnos(templario);
		
		int vidaInicial = otraUnidad.getVida();
		
		Coordenada posicion =  new Coordenada(5,5);
		mapa.almacenar(otraUnidad, posicion);
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, posicion);
		
		
		templario.tormentaPsionica(area);
		
		assertEquals(vidaInicial - 100, otraUnidad.getVida());
	}
	
	@Test
	public void testTormentaPsionicaHace100DeDanioLaSegundaVuelta() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		AltoTemplario templario = new AltoTemplario();
		Unidad otraUnidad = new NaveCiencia();
		
		pasarMuchosTurnos(templario);
		
		Coordenada posicion =  new Coordenada(5,5);
		mapa.almacenar(otraUnidad, posicion);
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, posicion);
		
		templario.tormentaPsionica(area);
		templario.iniciarTurno();
		
		assertEquals(true, otraUnidad.estoyMuerto());
	}
	
	@Test
	public void testTormentaPsionicaMata2NavesCienciaEnDosTurnos() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		AltoTemplario templario = new AltoTemplario();
		Unidad nave1 = new NaveCiencia();
		Unidad nave2 = new NaveCiencia();
		
		pasarMuchosTurnos(templario);
		
		Coordenada posicion1 = new Coordenada(5,5);
		Coordenada posicion2 = new Coordenada(5,6);
		
		mapa.almacenar(nave1, posicion1);
		mapa.almacenar(nave2, posicion2);
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, posicion1);
		
		templario.tormentaPsionica(area);
		templario.iniciarTurno();
		
		assertEquals(true, nave1.estoyMuerto() && nave2.estoyMuerto());
	}
	
	@Test
	public void testTormentaPsionicaNoSeActivaSinMagiaSuficiente() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		AltoTemplario templario = new AltoTemplario();
		Unidad otraUnidad = new NaveCiencia();
		
		int vidaInicial = otraUnidad.getVida();
		
		Coordenada posicion =  new Coordenada(5,5);
		mapa.almacenar(otraUnidad, posicion);
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, posicion);
		
		templario.tormentaPsionica(area);
		
		assertEquals(vidaInicial, otraUnidad.getVida());
	}
	
	@Test
	public void testTormentaPsionicaGasta75deEnergia() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		AltoTemplario templario = new AltoTemplario();
		
		pasarMuchosTurnos(templario);
		
		Collection<Terreno> area = mapa.obtenerRadioDeCasilleros(2, new Coordenada(5,5));
		
		templario.tormentaPsionica(area);
		
		assertEquals(templario.getMagiaMaxima() - 75, templario.getMagiaActual());
	}
	

}

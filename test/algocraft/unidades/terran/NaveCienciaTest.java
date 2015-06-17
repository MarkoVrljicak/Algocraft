package algocraft.unidades.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.exception.PropiedadNoEstaEnJuegoException;
import algocraft.mapa.Coordenada;
import algocraft.mapa.Mapa;
import algocraft.unidades.Unidad;
import algocraft.unidades.UnidadMagica;

public class NaveCienciaTest {
	
	int danioRadiacion = 10;
	
	public void pasarMuchosTurnos(NaveCiencia nave){
		//para llenar magia
		for(int i = 0; i<20; i++){
			nave.iniciarTurno();
		}
	}

	@Test
	public void testCreoNaveCienciaYControloSuVidaInicial() {
		
		NaveCiencia naveciencia = new NaveCiencia();
		
		assertEquals(200, naveciencia.getVida());
	}
	
	@Test
	public void testNaveCienciaVuela(){
		NaveCiencia naveCiencia = new NaveCiencia();
		
		assertEquals(true, naveCiencia.soyVolador());
	}
	
	@Test
	public void testSuminstrosNaveCienciaEs2(){
		NaveCiencia naveCiencia = new NaveCiencia();
		
		assertEquals(2,naveCiencia.getSuministros() );
	}
	
	@Test
	public void testMovimientosNaveCienciaEmpiezaEn5(){
		NaveCiencia naveCiencia = new NaveCiencia();
		
		assertEquals(5,naveCiencia.getMovimientos() );
	}
	
	@Test
	public void testTiempoDeConstruccionCorrecto(){
		final int tiempoDeConstruccion = 10;
		NaveCiencia naveCiencia= new NaveCiencia();
		
		assertEquals(true, naveCiencia.enConstruccion());
		
		for(int i = 0; i<tiempoDeConstruccion; i++){
			naveCiencia.disminuirTiempoDeConstruccion();
		}
		
		assertEquals(false, naveCiencia.enConstruccion());
	}
	
	@Test
	public void testNaveEmpiezaCon50DeMagia(){
		UnidadMagica nave = new NaveCiencia();
		
		assertEquals(50, nave.getMagiaActual());
		
	}
	
	@Test
	public void testNaveTieneMagiaMaxima200(){
		UnidadMagica nave = new NaveCiencia();
		
		assertEquals(200, nave.getMagiaMaxima());
		
	}
	
	@Test
	public void testNaveRegenera10DeMagia(){
		UnidadMagica nave = new NaveCiencia();
		nave.iniciarTurno();
		
		assertEquals(60, nave.getMagiaActual());
		
	}
	
	@Test
	public void testRadiacionGasta75DeMagia() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		pasarMuchosTurnos(nave);
		Unidad marine = new Marine();
		mapa.almacenar(marine, new Coordenada(4,4));
		
		int magiaOriginal = nave.getMagiaActual();
		
		nave.radiacion(marine, mapa);
		
		assertEquals(nave.getMagiaActual(), magiaOriginal - 75);
		
	}
	
	@Test
	public void testRadiacionNoSeActivaConMenosDe75DeMagia() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine = new Marine();
		mapa.almacenar(marine, new Coordenada(4,4));
		
		nave.radiacion(marine, mapa);
		
		assertEquals(marine.getVida(), marine.getVitalidadMaxima());
	}
	
	@Test
	public void testRadiacionHace10DeDanioEnUnTurno() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine = new Marine();
		mapa.almacenar(marine, new Coordenada(4,4));
		
		pasarMuchosTurnos(nave);
		
		nave.radiacion(marine, mapa);
		
		assertEquals(marine.getVitalidadMaxima() - danioRadiacion, marine.getVida());
	}
	
	@Test
	public void testRadiacionHace10DeDanioEnSegundoTurno() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine = new Marine();
		mapa.almacenar(marine, new Coordenada(4,4));
		
		pasarMuchosTurnos(nave);
		
		nave.radiacion(marine, mapa);
		nave.iniciarTurno();
		
		assertEquals(marine.getVitalidadMaxima() - danioRadiacion*2, marine.getVida());
	}
	
	@Test
	public void testUnidadSeMueveYSigueRecibiendoRadiacion() throws DestinoInvalidoException, FueraDeLimitesException, PropiedadNoEstaEnJuegoException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine = new Marine();
		mapa.almacenar(marine, new Coordenada(4,4));
		
		pasarMuchosTurnos(nave);
		
		nave.radiacion(marine, mapa);
		
		mapa.moverUnidad(marine, new Coordenada(4,5));
		
		nave.iniciarTurno();
		
		assertEquals(marine.getVitalidadMaxima() - danioRadiacion*2, marine.getVida());
	}
	
	@Test
	public void testRadiacionAfectaAUnidadesVecinas() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		mapa.almacenar(marine1, new Coordenada(4,4));
		mapa.almacenar(marine2, new Coordenada(4,5));
		
		pasarMuchosTurnos(nave);
		
		nave.radiacion(marine1, mapa);
		
		assertEquals(marine2.getVitalidadMaxima() - danioRadiacion, marine2.getVida());
	}
	
	@Test
	public void testRadiacionNoAfectaAUnidadesADistancia2() throws DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		mapa.almacenar(marine1, new Coordenada(4,4));
		mapa.almacenar(marine2, new Coordenada(4,6));
		
		pasarMuchosTurnos(nave);
		
		nave.radiacion(marine1, mapa);
		
		assertEquals(marine2.getVitalidadMaxima(), marine2.getVida());
	}
	
	@Test
	public void testRadiacionDejaDeAfectarASegundaUnidadCuandoSeDespegaDeLaAfectada() throws DestinoInvalidoException, FueraDeLimitesException, PropiedadNoEstaEnJuegoException{
		Mapa mapa = new Mapa(10,10);
		NaveCiencia nave = new NaveCiencia();
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		mapa.almacenar(marine1, new Coordenada(4,4));
		mapa.almacenar(marine2, new Coordenada(4,5));
		
		pasarMuchosTurnos(nave);
		
		nave.radiacion(marine1, mapa);
		
		mapa.moverUnidad(marine2, new Coordenada(4,6));
		
		nave.iniciarTurno();
		
		assertEquals(marine2.getVitalidadMaxima() - danioRadiacion, marine2.getVida());
	}

	
}

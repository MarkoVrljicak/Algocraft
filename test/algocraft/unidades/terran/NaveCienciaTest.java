package algocraft.unidades.terran;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.unidades.UnidadMagica;

public class NaveCienciaTest {

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
	public void testTemplarioTieneMagiaMaxima200(){
		UnidadMagica nave = new NaveCiencia();
		
		assertEquals(200, nave.getMagiaMaxima());
		
	}
	
	@Test
	public void testTemplarioRegenera10DeMagia(){
		UnidadMagica nave = new NaveCiencia();
		nave.iniciarTurno();
		
		assertEquals(60, nave.getMagiaActual());
		
	}
	
}

package algocraft.mapa;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.ActualizableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Alternativas.Unidad;
import algocraft.unidades.Alternativas.terran.Marine;
import algocraft.unidades.Alternativas.terran.NaveCiencia;

public class MapaTest {
	
	@Test
	public void testObtenerCasilleroDevuelveCasilleroConEsaCoordenada() throws FueraDeLimitesException{
		Mapa mapa= new Mapa(100,100);
		Coordenada coordenadaPedida= new Coordenada(50,50);
		
		Terreno casillero= mapa.obtenerCasillero(coordenadaPedida);
		
		assertEquals(coordenadaPedida, casillero.getCoordenada());
	}
	
	@Test(expected= FueraDeLimitesException.class)
	public void testObtenerCasilleroFueraDeLimitesLanzaExcepcion() throws FueraDeLimitesException{
		Mapa mapa= new Mapa(100,100);
		Coordenada coordenadaPedida= new Coordenada(150,150);
		
		mapa.obtenerCasillero(coordenadaPedida);
	}
	
	@Test
	public void testObtengoAnchoMiroQueSeaElAncho(){
		Mapa mapa= new Mapa(100,200);
		
		assertEquals(100,mapa.getAncho());
	}
	
	@Test
	public void testObtengoAltoMiroQueSeaElAlto(){
		Mapa mapa= new Mapa(100,200);
		
		assertEquals(200,mapa.getAlto());
	}
	
	@Test
	public void testHayCasilleroEnMapaDevuelveVerdadero(){
		Mapa mapa= new Mapa(100,200);
		
		assertEquals(true,mapa.hayCasillero(new Coordenada(10,20)));
	}
	
	@Test
	public void testHayCasilleroNoEnMapaDevuelveFalso(){
		Mapa mapa= new Mapa(100,200);
		
		assertEquals(false,mapa.hayCasillero(new Coordenada(101,20)));
	}
	
	@Test
	public void testMapaMueveUnidadPorTierra(){
		Mapa mapa= new Mapa(2,2);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverPorTierra(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, mapa.getActualizableSuelo(destino));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorTierraOrigenEstaVacio(){
		Mapa mapa= new Mapa(2,2);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverPorTierra(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getActualizableSuelo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoEstaOcupadoPorOtraUnidad() throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException{
		Mapa mapa= new Mapa(2,2);
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine1, origen);
			mapa.almacenarEnSuelo(marine2, destino);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, mapa.moverPorTierra(marine1, destino));
		
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoNoEsTierra() throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException{
		Mapa mapa= new Mapa(2,2);
		Unidad marine = new Marine();
		
		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 1, 2);
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false,	mapa.moverPorTierra(marine, destino));
		
	}
	
	@Test
	public void testMapaMueveUnidadPorAire() throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		mapa.moverPorCielo(nave, destino);
		
		assertEquals(nave, mapa.getActualizableCielo(destino));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorAireOrigenEstaVacio(){
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverPorCielo(nave, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getActualizableCielo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorCieloSiDestinoEstaOcupadoPorOtraUnidad() throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave1 = new NaveCiencia();
		Unidad nave2 = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave1, origen);
			mapa.almacenarEnCielo(nave2, destino);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, mapa.moverPorCielo(nave1, destino));
		
	}
	
//	@Test
//	public void testMapaGestionaAtaqueEntreDosUnidades(){
//		Mapa mapa = new Mapa(5,5);
//		Unidad marine1 = new Marine();
//		Unidad marine2 = new Marine();
//		
//		assertEquals(true, mapa.gestionarAtaque(marine1, marine2));
//	}
//	
//	@Test
//	public void testMapaGestionaAtaqueEntreDosUnidadesYDisminuyeVidaDeUnidadAtacada(){
//		Mapa mapa = new Mapa(5,5);
//		Unidad marine1 = new Marine();
//		Unidad marine2 = new Marine();
//		
//		mapa.gestionarAtaque(marine1, marine2);
//		
//		assertEquals(34, marine2.getVida());
//	}
	
}

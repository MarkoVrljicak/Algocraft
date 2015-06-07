package algocraft.mapa;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.CreableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Unidad;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

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
		} catch (CreableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, mapa.getCreableSuelo(destino));
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
		} catch (CreableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getCreableSuelo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoEstaOcupadoPorOtraUnidad() throws DestinoInvalidoException, CreableNoEstaEnJuegoException{
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
	public void testMapaNoMueveUnidadPorTierraSiDestinoNoEsTierra() throws DestinoInvalidoException, CreableNoEstaEnJuegoException{
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
	public void testMapaMueveUnidadPorAire() throws CreableNoEstaEnJuegoException, DestinoInvalidoException{
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
		
		assertEquals(nave, mapa.getCreableCielo(destino));
	}
	
}

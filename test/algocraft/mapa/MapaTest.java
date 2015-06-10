package algocraft.mapa;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.ActualizableNoEstaEnJuegoException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;
import algocraft.mapa.terrenos.Terrenos;
import algocraft.unidades.Unidad;
import algocraft.unidades.protos.Dragon;
import algocraft.unidades.terran.Marine;
import algocraft.unidades.terran.NaveCiencia;

public class MapaTest {
	
	@Test
	public void testObtenerCasilleroDevuelveCasilleroConEsaCoordenada() throws FueraDeLimitesException{
		Mapa mapa= new Mapa(100,100);
		Coordenada coordenadaPedida= new Coordenada(50,50);
		
		Terreno casillero= mapa.getTerreno(coordenadaPedida);
		
		assertEquals(coordenadaPedida, casillero.getCoordenada());
	}
	
	@Test
	public void testObtenerActualizablesEnJuego() throws FueraDeLimitesException, DestinoInvalidoException{
		Mapa mapa= new Mapa(100,100);
		Coordenada coordenada = new Coordenada(50,50);
		
		Unidad marine = new Marine();
		mapa.almacenarEnSuelo(marine, coordenada);
		
		assertEquals(1, mapa.actualizablesEnJuego());
	}
	
	@Test(expected= FueraDeLimitesException.class)
	public void testObtenerCasilleroFueraDeLimitesLanzaExcepcion() throws FueraDeLimitesException{
		Mapa mapa= new Mapa(100,100);
		Coordenada coordenadaPedida= new Coordenada(150,150);
		
		mapa.getTerreno(coordenadaPedida);
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
	
	// tests de movimiento
	
	@Test
	public void testMapaMueveUnidadPorTierra() throws FueraDeLimitesException{
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
			mapa.moverUnidad(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, mapa.getActualizableSuelo(destino));
	}
	
	@Test
	public void testMapaMueveADistanciaEnRangoDeMovimientos() 
			throws FueraDeLimitesException{
		Mapa mapa= new Mapa(5,5);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(2,4);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverUnidad(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, mapa.getActualizableSuelo(destino));
	}
	
	@Test
	public void testMapaNoMueveUnidadSiDistanciaFueraDeRangoDeMovimientos() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(5,5);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(5,5);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverUnidad(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(false, mapa.moverUnidad(marine, destino));
	}
	
	@Test
	public void testMapaNoMueveUnidadTerrestreATravesDeAire() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(3,3);
		Unidad marine = new Marine();
		Coordenada origen = new Coordenada(1,2);
		Coordenada destino = new Coordenada(3,2);
		//posiciono el marine
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		//hago un "rio" de aire
		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 2, 1);
		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 2, 2);
		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 2, 3);
		
		assertEquals(false, mapa.moverUnidad(marine, destino));
	}
	
	@Test
	public void testMapaMueveUnidadReduceMovimientosRestantes(){
		Mapa mapa= new Mapa(2,3);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,3);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException | FueraDeLimitesException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverUnidad(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException | FueraDeLimitesException e) {
			e.printStackTrace();
		}
		
		assertEquals(1, marine.getMovimientos().actual());
	}
	
	@Test
	public void testMapaNoMueveUnidadSiNoHayMovimientosRestantesSuficientes() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(4,4);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(3,3);
		
		try {
			mapa.almacenarEnSuelo(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverUnidad(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		//intento volver al origen
		assertEquals(false, mapa.moverUnidad(marine, origen));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorTierraOrigenEstaVacio() 
			throws FueraDeLimitesException{
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
			mapa.moverUnidad(marine, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getActualizableSuelo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoEstaOcupadoPorOtraUnidad() 
			throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException, FueraDeLimitesException{
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
		
		assertEquals(false, mapa.moverUnidad(marine1, destino));
		
	}
	
	@Test
	public void testMapaNoMueveUnidadPorTierraSiDestinoNoEsTierra() 
			throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException, FueraDeLimitesException{
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
		
		assertEquals(false,	mapa.moverUnidad(marine, destino));
		
	}
	
	@Test
	public void testMapaMueveUnidadPorAire() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		mapa.moverUnidad(nave, destino);
		
		assertEquals(nave, mapa.getActualizableCielo(destino));
	}
	
	@Test
	public void testMapaMueveUnidadPorAireInclusoSiDestinoOcupadoEnTierra() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		Unidad marine= new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenarEnCielo(nave, origen);
			mapa.almacenarEnSuelo(marine, destino);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		mapa.moverUnidad(nave, destino);
		
		assertEquals(nave, mapa.getActualizableCielo(destino));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorAireOrigenEstaVacio() throws FueraDeLimitesException{
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
			mapa.moverUnidad(nave, destino);
		} catch (ActualizableNoEstaEnJuegoException | DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getActualizableCielo(origen));
	}
	
	@Test
	public void testMapaNoMueveUnidadPorCieloSiDestinoEstaOcupadoPorOtraUnidad() 
			throws DestinoInvalidoException, ActualizableNoEstaEnJuegoException, FueraDeLimitesException{
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
		
		assertEquals(false, mapa.moverUnidad(nave1, destino));
		
	}
	
	//tests gestion ataque
	
	@Test
	public void testMapaGestionaAtaqueEntreDosUnidades() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		mapa.almacenarEnSuelo(marine1, new Coordenada(1,1));
		mapa.almacenarEnSuelo(marine2, new Coordenada(2,2));
		
		assertEquals(true, mapa.gestionarAtaque(marine1, marine2));
	}
	
	@Test
	public void testMapaGestionaAtaqueEntreDosUnidadesYDisminuyeVidaDeUnidadAtacada() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		mapa.almacenarEnSuelo(marine1, new Coordenada(1,1));
		mapa.almacenarEnSuelo(marine2, new Coordenada(2,2));
		
		mapa.gestionarAtaque(marine1, marine2);
		
		assertEquals(34, marine2.getVida());
	}
	
	@Test
	public void testPeleaGestionadaPorMapaResultaEnMuerte() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad dragon = new Dragon();
		Unidad marine = new Marine();
		
		mapa.almacenarEnSuelo(dragon, new Coordenada(1,1));
		mapa.almacenarEnSuelo(marine, new Coordenada(2,2));
		
		mapa.gestionarAtaque(dragon, marine);
		mapa.gestionarAtaque(dragon, marine);
		
		assertEquals(true, marine.estoyMuerto());
	}
	
	@Test
	public void testMapaEliminaUnidadMatada() 
			throws ActualizableNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad dragon = new Dragon();
		Unidad marine = new Marine();
		
		mapa.almacenarEnSuelo(dragon, new Coordenada(1,1));
		mapa.almacenarEnSuelo(marine, new Coordenada(2,2));
		
		mapa.gestionarAtaque(dragon, marine);
		mapa.gestionarAtaque(dragon, marine);
		
		assertEquals(1, mapa.actualizablesEnJuego());
	}
	
}

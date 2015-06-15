package algocraft.mapa;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collection;

import org.junit.Test;

import algocraft.exception.CoordenadaInexistenteException;
import algocraft.exception.DestinoInvalidoException;
import algocraft.exception.FueraDeLimitesException;
import algocraft.exception.PropiedadNoEstaEnJuegoException;
import algocraft.mapa.terrenos.Terreno;
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
		mapa.almacenar(marine, coordenada);
		
		assertEquals(1, mapa.propiedadesEnJuego());
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
			mapa.almacenar(marine, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverUnidad(marine, destino);
		} catch (PropiedadNoEstaEnJuegoException e) {
			e.printStackTrace();
		}
		
		assertEquals(marine, mapa.getPropiedadSuelo(destino));
	}
	
//	@Test
//	public void testMapaMueveADistanciaEnRangoDeMovimientos() 
//			throws FueraDeLimitesException{
//		Mapa mapa= new Mapa(5,5);
//		Unidad marine = new Marine();
//		
//		Coordenada origen = new Coordenada(1,1);
//		Coordenada destino = new Coordenada(2,4);
//		
//		try {
//			mapa.almacenar(marine, origen);
//		} catch (DestinoInvalidoException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			mapa.desplazarPropiedad(marine, destino);
//		} catch (PropiedadNoEstaEnJuegoException e) {
//			e.printStackTrace();
//		}
//		
//		assertEquals(marine, mapa.getPropiedadSuelo(destino));
//	}
	
//	@Test
//	public void testMapaNoMueveUnidadSiDistanciaFueraDeRangoDeMovimientos() 
//			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
//		Mapa mapa= new Mapa(5,5);
//		Unidad marine = new Marine();
//		
//		Coordenada origen = new Coordenada(1,1);
//		Coordenada destino = new Coordenada(5,5);
//		
//		try {
//			mapa.almacenar(marine, origen);
//		} catch (DestinoInvalidoException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			mapa.desplazarPropiedad(marine, destino);
//		} catch (PropiedadNoEstaEnJuegoException e) {
//			e.printStackTrace();
//		}
//		
//		assertEquals(false, mapa.desplazarPropiedad(marine, destino));
//	}
//	
//	@Test
//	public void testMapaNoMueveUnidadTerrestreATravesDeAire() 
//			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
//		Mapa mapa= new Mapa(3,3);
//		Unidad marine = new Marine();
//		Coordenada origen = new Coordenada(1,2);
//		Coordenada destino = new Coordenada(3,2);
//		//posiciono el marine
//		try {
//			mapa.almacenar(marine, origen);
//		} catch (DestinoInvalidoException e) {
//			e.printStackTrace();
//		}
//		//hago un "rio" de aire
//		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 2, 1);
//		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 2, 2);
//		mapa.setearTerrenoEnCoordenada(Terrenos.AIRE, 2, 3);
//		
//		assertEquals(false, mapa.moverUnidad(marine, destino));
//	}
//	
//	@Test
//	public void testMapaMueveUnidadReduceMovimientosRestantes(){
//		Mapa mapa= new Mapa(2,3);
//		Unidad marine = new Marine();
//		
//		Coordenada origen = new Coordenada(1,1);
//		Coordenada destino = new Coordenada(1,3);
//		
//		try {
//			mapa.almacenar(marine, origen);
//		} catch (DestinoInvalidoException | FueraDeLimitesException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			mapa.moverUnidad(marine, destino);
//		} catch (PropiedadNoEstaEnJuegoException | DestinoInvalidoException | FueraDeLimitesException e) {
//			e.printStackTrace();
//		}
//		
//		assertEquals(1, marine.getMovimientos().actual());
//	}
//	
//	@Test
//	public void testMapaNoMueveUnidadSiNoHayMovimientosRestantesSuficientes() 
//			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
//		Mapa mapa= new Mapa(4,4);
//		Unidad marine = new Marine();
//		
//		Coordenada origen = new Coordenada(1,1);
//		Coordenada destino = new Coordenada(3,3);
//		
//		try {
//			mapa.almacenar(marine, origen);
//		} catch (DestinoInvalidoException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			mapa.moverUnidad(marine, destino);
//		} catch (PropiedadNoEstaEnJuegoException | DestinoInvalidoException e) {
//			e.printStackTrace();
//		}
//		//intento volver al origen
//		assertEquals(false, mapa.moverUnidad(marine, origen));
//	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorTierraOrigenEstaVacio() 
			throws FueraDeLimitesException, PropiedadNoEstaEnJuegoException, DestinoInvalidoException{
		Mapa mapa= new Mapa(2,2);
		Unidad marine = new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		
		mapa.almacenar(marine, origen);
		
		mapa.moverUnidad(marine, destino);
		
		assertEquals(null, mapa.getPropiedadSuelo(origen));
	}
	
	@Test
	public void testMapaMueveUnidadPorAire() 
			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenar(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		mapa.moverUnidad(nave, destino);
		
		assertEquals(nave, mapa.getPropiedadCielo(destino));
	}
	
	@Test
	public void testMapaMueveUnidadPorAireInclusoSiDestinoOcupadoEnTierra() 
			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		Unidad marine= new Marine();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenar(nave, origen);
			mapa.almacenar(marine, destino);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		mapa.moverUnidad(nave, destino);
		
		assertEquals(nave, mapa.getPropiedadCielo(destino));
	}
	
	@Test
	public void testCuandoMapaMueveUnidadPorAireOrigenEstaVacio() throws FueraDeLimitesException{
		Mapa mapa= new Mapa(2,2);
		Unidad nave = new NaveCiencia();
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(1,2);
		
		try {
			mapa.almacenar(nave, origen);
		} catch (DestinoInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			mapa.moverUnidad(nave, destino);
		} catch (PropiedadNoEstaEnJuegoException e) {
			e.printStackTrace();
		}
		
		assertEquals(null, mapa.getPropiedadCielo(origen));
	}
	
	//tests gestion ataque
	
	@Test
	public void testMapaGestionaAtaqueEntreDosUnidades() 
			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		mapa.almacenar(marine1, new Coordenada(1,1));
		mapa.almacenar(marine2, new Coordenada(2,2));
		
		assertEquals(true, mapa.gestionarAtaque(marine1, marine2));
	}
	
	@Test
	public void testMapaGestionaAtaqueEntreDosUnidadesYDisminuyeVidaDeUnidadAtacada() 
			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad marine1 = new Marine();
		Unidad marine2 = new Marine();
		
		mapa.almacenar(marine1, new Coordenada(1,1));
		mapa.almacenar(marine2, new Coordenada(2,2));
		
		mapa.gestionarAtaque(marine1, marine2);
		
		assertEquals(34, marine2.getVida());
	}
	
	@Test
	public void testPeleaGestionadaPorMapaResultaEnMuerte() 
			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad dragon = new Dragon();
		Unidad marine = new Marine();
		
		mapa.almacenar(dragon, new Coordenada(1,1));
		mapa.almacenar(marine, new Coordenada(2,2));
		
		mapa.gestionarAtaque(dragon, marine);
		mapa.gestionarAtaque(dragon, marine);
		
		assertEquals(true, marine.estoyMuerto());
	}
	
	@Test
	public void testMapaEliminaUnidadMatada() 
			throws PropiedadNoEstaEnJuegoException, DestinoInvalidoException, FueraDeLimitesException{
		Mapa mapa = new Mapa(5,5);
		Unidad dragon = new Dragon();
		Unidad marine = new Marine();
		
		mapa.almacenar(dragon, new Coordenada(1,1));
		mapa.almacenar(marine, new Coordenada(2,2));
		
		mapa.gestionarAtaque(dragon, marine);
		mapa.gestionarAtaque(dragon, marine);
		
		assertEquals(1, mapa.propiedadesEnJuego());
	}
	
	@Test
	public void mapaDevuelve9CasillerosAlObtenerUnRadioDe1ConCentroEnUnCasilleroQueNoEstaEnElBorde(){
		Mapa mapa = new Mapa(10,10);
		
		Collection<Terreno> casilleros = mapa.obtenerRadioDeCasilleros(1, new Coordenada(3,3));
		
		assertEquals(9, casilleros.size());
	}
	
	@Test
	public void mapaDevuelve4CasillerosAlObtenerUnRadioDe1ConCentroEnUnaEsquina(){
		Mapa mapa = new Mapa(10,10);
		
		Collection<Terreno> casilleros = mapa.obtenerRadioDeCasilleros(1, new Coordenada(1,1));
		
		assertEquals(4, casilleros.size());
	}
	
	@Test
	public void mapaDevuelve6CasillerosAlObtenerUnRadioDe1ConCentroEnUnaPared(){
		Mapa mapa = new Mapa(10,10);
		
		Collection<Terreno> casilleros = mapa.obtenerRadioDeCasilleros(1, new Coordenada(1,5));
		
		assertEquals(6, casilleros.size());
	}
	
	@Test
	public void mapaDevuelve25CasillerosAlObtenerUnRadioDe2ConCentroEnUnCasilleroQueNoEstaEnElBorde(){
		Mapa mapa = new Mapa(10,10);
		
		Collection<Terreno> casilleros = mapa.obtenerRadioDeCasilleros(2, new Coordenada(3,3));
		
		assertEquals(25, casilleros.size());
	}
	
	//Obtencion de caminos
	
	@Test
	public void testMapaDevuelveUnCaminoNoVacio() throws CoordenadaInexistenteException{
		Mapa mapa = new Mapa(3,3);
		
		Collection<Terreno> camino = mapa.trazarCamino(new Coordenada(1,1), new Coordenada(3,3));
				
		assertFalse(camino.size() == 0);
	}
	
	@Test
	public void testElLargoDeUnCaminoEsIgualALaDistanciaEntreDosCoordenadasMasUno() throws CoordenadaInexistenteException{
		Mapa mapa = new Mapa(10,10);
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(7,9);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
				
		assertEquals(camino.size() , origen.distanciaA(destino) +1);
	}
	
	@Test
	public void testCaminoConOrigenIgualADestinoEsDeTamanio1() throws CoordenadaInexistenteException{
		Mapa mapa = new Mapa(3,3);
		
		Collection<Terreno> camino = mapa.trazarCamino(new Coordenada(1,1), new Coordenada(1,1));
				
		assertEquals(1, camino.size());
	}
	
	@Test(expected = CoordenadaInexistenteException.class)
	public void testTrazarCaminosLanzaCoordenadaInexistenteSiNoExisteDestino() throws CoordenadaInexistenteException{
		Mapa mapa = new Mapa(3,3);
		
		mapa.trazarCamino(new Coordenada(1,1), new Coordenada(10,1));
	}
	
	@Test(expected = CoordenadaInexistenteException.class)
	public void testTrazarCaminosLanzaCoordenadaInexistenteSiNoExisteOrigen() throws CoordenadaInexistenteException{
		Mapa mapa = new Mapa(3,3);
		
		mapa.trazarCamino(new Coordenada(0,1), new Coordenada(1,1));
	}
	
	@Test
	public void testCaminoContieneAlOrigen() throws CoordenadaInexistenteException, FueraDeLimitesException{
		Mapa mapa = new Mapa(3,3);
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(3,3);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
				
		assertEquals(true , camino.contains(mapa.getTerreno(origen)));
	}
	
	@Test
	public void testCaminoContieneAlDestino() throws CoordenadaInexistenteException, FueraDeLimitesException{
		Mapa mapa = new Mapa(3,3);
		
		Coordenada origen = new Coordenada(1,1);
		Coordenada destino = new Coordenada(3,3);
		
		Collection<Terreno> camino = mapa.trazarCamino(origen, destino);
				
		assertEquals(true , camino.contains(mapa.getTerreno(destino)));
	}
	
	
}

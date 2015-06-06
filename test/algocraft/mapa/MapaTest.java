package algocraft.mapa;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algocraft.exception.FueraDeLimitesException;
import algocraft.mapa.terrenos.Terreno;

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
	
}

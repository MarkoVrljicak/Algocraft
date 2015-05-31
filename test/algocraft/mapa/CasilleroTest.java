package algocraft.mapa;

import org.junit.Assert;
import org.junit.Test;


public class CasilleroTest {
	
	@Test
	public void testCasilleroEmpiezaVacio(){
		Casillero c= new Casillero(new Coordenada(1,3) );
		
		Assert.assertEquals(true, c.estaVacio());
	}
	
	
	@Test
	public void testCasilleroSeCreaConUnaCoordenada(){
		Coordenada unaCoordenada= new Coordenada(1,5);
		Casillero casillero = new Casillero(unaCoordenada);
		
		Assert.assertEquals(unaCoordenada, casillero.coordenada );
	}
	
	
	@Test
	public void testPonerAlgoEnElCasilleroLoHaceNoVacio(){
		Casillero c= new Casillero( new Coordenada(1,4) );
		c.contenido= "algo";
		
		Assert.assertEquals(false,c.estaVacio());
	}
	
	
	@Test
	public void testObtenerCoordenadaDevuelveUnaCoordenadaIgual(){
		Coordenada coordenadaInicial= new Coordenada(1,7);
		Casillero casillero= new Casillero( coordenadaInicial );
		
		Coordenada coordenadaObtenida= casillero.getCoordenada();
		
		Assert.assertEquals(coordenadaInicial,coordenadaObtenida);
	}
	
}
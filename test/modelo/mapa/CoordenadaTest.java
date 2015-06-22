package modelo.mapa;

import modelo.mapa.Coordenada;

import org.junit.Assert;
import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void testDosCoordenadaSonIgualesSiTienenMismoXeY() {
		Coordenada c1 = new Coordenada(1, 5);
		Coordenada c2 = new Coordenada(1, 5);

		Assert.assertEquals(c1, c2);
	}
	
	@Test
	public void testDosCoordenadaSonIgualesSiTienenMismoXoY() {
		Coordenada c1 = new Coordenada(1, 5);
		Coordenada c2 = new Coordenada(1, 3);

		Assert.assertNotSame(c1, c2);
	}
	
	@Test
	public void testUnaCoordenadaNoEsIgualAAlgoDeOtroTipo() {
		Coordenada c1 = new Coordenada(1, 5);
		String coordenadaFalsa= "10,20";

		Assert.assertNotSame(c1, coordenadaFalsa);
	}

	@Test
	public void testHashcodeIgualSiTieneIgualXY() {
		Coordenada c1 = new Coordenada(1, 3);
		Coordenada c2 = new Coordenada(1, 3);

		Assert.assertEquals(c1.hashCode(), c2.hashCode());
	}

	@Test
	public void testDistanciaHorizontal() {
		Coordenada c1 = new Coordenada(5, 0);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia = c1.distanciaA(c2);

		Assert.assertEquals(5, distancia);
	}
	
	@Test
	public void testDistanciaVertical() {
		Coordenada c1 = new Coordenada(0, 5);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia = c1.distanciaA(c2);

		Assert.assertEquals(5, distancia);
	}
	
	@Test
	public void testCasilleroDiagonalEstaA1DeDistancia() {
		Coordenada c1 = new Coordenada(1, 1);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia = c1.distanciaA(c2);

		Assert.assertEquals(1, distancia);
	}
	
	@Test
	public void testDistanciaEnDiagonalMasHorizontal() {
		Coordenada c1 = new Coordenada(2, 1);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia = c1.distanciaA(c2);

		Assert.assertEquals(2, distancia);
	}
	
	@Test
	public void testDistanciaEnDiagonalMasVertical() {
		Coordenada c1 = new Coordenada(2, 3);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia = c1.distanciaA(c2);

		Assert.assertEquals(3, distancia);
	}

	@Test
	public void testDistanciaEsIndependienteDelOrden() {
		Coordenada c1 = new Coordenada(2, 3);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia1 = c1.distanciaA(c2);
		int distancia2 = c2.distanciaA(c1);

		Assert.assertEquals(distancia1, distancia2);
	}

}

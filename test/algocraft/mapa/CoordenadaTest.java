package algocraft.mapa;

import org.junit.Assert;
import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void testDosCoordenadaSonIgualesSiTienenMismoXY() {
		Coordenada c1 = new Coordenada(1, 5);
		Coordenada c2 = new Coordenada(1, 5);

		Assert.assertEquals(c1, c2);
	}

	@Test
	public void testHashcodeIgualSiTieneIgualXY() {
		Coordenada c1 = new Coordenada(1, 3);
		Coordenada c2 = new Coordenada(1, 3);

		Assert.assertEquals(c1.hashCode(), c2.hashCode());
	}

	@Test
	public void testHashcodeNoIgualSiTieneDistintoXY() {
		Coordenada c1 = new Coordenada(1, 3);
		Coordenada c2 = new Coordenada(3, 4);

		double hash1 = c1.hashCode();
		double hash2 = c2.hashCode();
		boolean iguales = (hash1 == hash2);

		Assert.assertEquals(false, iguales);
	}

	@Test
	public void testDistanciaACoordenadaEsDiferenciaEntreAmbas() {
		Coordenada c1 = new Coordenada(2, 3);
		Coordenada c2 = new Coordenada(0, 0);

		int distancia = c1.distanciaA(c2);

		Assert.assertEquals(5, distancia);
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

package algocraft.mapa;

import algocraft.construcciones.BaseTerran;
import algocraft.construcciones.Construccion;
import algocraft.creables.Creable;
import algocraft.exception.FueraDeLimitesException;

public class GeneradorDeMapa {
	// ES COMMMAND, crea un mapa muy basico y cuadrado para testear
	// funcionalidades

	private static final int distanciaMinimaBaseABorde = 6;
	private static final double proporcion =((double)2) / 3;
	private static final int escala = 30;
	private int ancho;
	private int alto;
	private Mapa mapa;

	public Mapa generarMapaBasico() {

		mapa = new Mapa(this.calcularAncho(), this.calcularAlto());

		llenarDeTierra();
		posicionarRecursos();
		posicionarBases();

		return mapa;
	}

	private int calcularAncho() {
		ancho = escala;
		return ancho;
	}

	private int calcularAlto() {
		alto = (int) Math.round( ( (double)escala )  * proporcion);
		return alto;
	}

	private void llenarDeTierra() {

		for (int i = 1; i <= ancho; i++) {
			for (int j = 1; j <= alto; j++) {
				setearTerrenoEnCasillero(new Tierra(), i, j);
			}
		}
	}

	private void posicionarBases() {
		Construccion unaBase = new BaseTerran();
		posicionarConstruccion(unaBase, distanciaMinimaBaseABorde,
				distanciaMinimaBaseABorde);
		unaBase = new BaseTerran();
		posicionarConstruccion(unaBase, ancho - distanciaMinimaBaseABorde, alto
				- distanciaMinimaBaseABorde);
	}

	private void posicionarConstruccion(Construccion unaConstruccion, int i, int j) {
		Coordenada unaCoordenada = new Coordenada(i, j);
		try {
			Casillero unCasillero = mapa.obtenerCasillero(unaCoordenada);
			unCasillero.almacenar((Creable) unaConstruccion);
		} catch (FueraDeLimitesException e) {
			// no deberia pasar
			e.printStackTrace();
		}
	}

	private void posicionarRecursos() {
		ponerMineralesEnLasEsquinas();
		ponerVolcanesEnLasEsquinas();

	}

	private void ponerVolcanesEnLasEsquinas() {
		setearTerrenoEnCasillero(new Volcan(), 2, 3);
		setearTerrenoEnCasillero(new Volcan(), ancho - 2, 3);
		setearTerrenoEnCasillero(new Volcan(), 2, alto - 3);
		setearTerrenoEnCasillero(new Volcan(), ancho - 2, alto - 3);
	}

	private void ponerMineralesEnLasEsquinas() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				setearTerrenoEnCasillero(new Minerales(), i, j);
			}
		}
		for (int i = ancho - 3; i <= ancho; i++) {
			for (int j = 1; j <= 2; j++) {
				setearTerrenoEnCasillero(new Minerales(), i, j);
			}
		}
		for (int i = 1; i <= 3; i++) {
			for (int j = alto - 1; j <= alto; j++) {
				setearTerrenoEnCasillero(new Minerales(), i, j);
			}
		}
		for (int i = ancho - 3; i <= ancho; i++) {
			for (int j = 1; j <= 2; j++) {
				setearTerrenoEnCasillero(new Minerales(), i, j);
			}
		}
	}

	private void setearTerrenoEnCasillero(Terreno unTerreno, int i, int j) {
		Coordenada unaCoordenada = new Coordenada(i, j);
		try {
			Casillero unCasillero = mapa.obtenerCasillero(unaCoordenada);
			unCasillero.setTerreno(unTerreno);
		} catch (FueraDeLimitesException e) {
			// no deberia pasar
			e.printStackTrace();
		}
	}

}

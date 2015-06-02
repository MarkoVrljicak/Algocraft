package algocraft.mapa;

import algocraft.exception.FueraDeLimitesException;

public class MirarMapa {

	public static void main(String[] args) {
		GeneradorDeMapaAleatorio generador= new GeneradorDeMapaAleatorio();
		VisualizadorMapaBasico visualizador= new VisualizadorMapaBasico();
		try {
			visualizador.visualizarMapaPorConsola( generador.generarMapaAleatorio() );
		} catch (FueraDeLimitesException e) {
			e.printStackTrace();
		}
		System.out.println(' ');
		System.out.println("mapa impreso");
	}

}

package algocraft.mapa;

import algocraft.exception.FueraDeLimitesException;

public class MirarMapa {

	public static void main(String[] args) {
		GeneradorDeMapaAlt generador= new GeneradorDeMapaAlt();
		VisualizadorMapaBasico visualizador= new VisualizadorMapaBasico();
		try {
			visualizador.visualizarMapaPorConsola( generador.generar() );
		} catch (FueraDeLimitesException e) {
			e.printStackTrace();
		}
		System.out.println(' ');
		System.out.println("mapa impreso");
	}

}

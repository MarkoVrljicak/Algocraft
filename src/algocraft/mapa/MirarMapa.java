package algocraft.mapa;

import algocraft.exception.FueraDeLimitesException;

public class MirarMapa {

	public static void main(String[] args) {
		GeneradorDeMapa generador= new GeneradorDeMapa(22, 22);
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

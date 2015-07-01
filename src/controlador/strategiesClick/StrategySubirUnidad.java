package controlador.strategiesClick;

import controlador.Controlador;
import modelo.Juego;
import modelo.unidades.UnidadTransportadora;
import visual.Seleccionable;

public class StrategySubirUnidad implements StrategyAccion {

	private UnidadTransportadora unidadTransportadora;

	public StrategySubirUnidad(UnidadTransportadora unidadTransportadora) {
		this.unidadTransportadora = unidadTransportadora;
	}

	@Override
	public void accionPara(Seleccionable accionado, Juego juego,
			Controlador controlador) {
		controlador.subirUnidad(unidadTransportadora, accionado);
		controlador.escribirEnLog("Subiendo unidad:" + unidadTransportadora.getNombre().toString());
	}

}

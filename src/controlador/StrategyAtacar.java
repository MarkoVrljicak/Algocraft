package controlador;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadAtacante;

public class StrategyAtacar implements StrategyAccion {

	private UnidadAtacante unidad;

	public StrategyAtacar(UnidadAtacante unidad) {
		this.unidad = unidad;
	}

	@Override
	public void accionSuelo(Coordenada posicionAtacado, Juego juego,Controlador controlador) {
		controlador.realizarAtaque(unidad,posicionAtacado);
	}

}

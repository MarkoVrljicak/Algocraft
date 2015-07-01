package controlador.strategiesClick;

import controlador.Controlador;
import modelo.Juego;
import modelo.unidades.Unidad;
import visual.Seleccionable;

public class StrategyMovimiento implements StrategyAccion {

	private Unidad unidad;

	public StrategyMovimiento(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void accionPara(Seleccionable accionado, Juego juego, Controlador controlador) {
		controlador.moverUnidad(unidad, accionado.obtenerPosicion());
		controlador.escribirEnLog(
				"Moviendo unidad:" + unidad.getNombre().toString()
				+ " a posicion:" + accionado.obtenerPosicion().getX() + "/" +accionado.obtenerPosicion().getY());
	}

}

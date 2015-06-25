package controlador;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;

public class StrategyMovimiento implements StrategyAccion {

	private Unidad unidad;

	public StrategyMovimiento(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void accionSuelo(Coordenada posicion,Juego juego,Controlador controlador) {
		controlador.moverUnidad(unidad, posicion);
		controlador.escribirEnLog(
				"Moviendo unidad:" + unidad.getNombre().toString()
				+ " a posicion:" + posicion.getX() + "/" + posicion.getY());
	}

}

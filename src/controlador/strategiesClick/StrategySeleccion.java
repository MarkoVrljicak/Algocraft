package controlador.strategiesClick;

import javax.swing.JToolBar;

import controlador.Controlador;
import modelo.Juego;
import visual.Seleccionable;

public class StrategySeleccion implements StrategyAccion {

	@Override
	public void accionPara(Seleccionable accionado, Juego juego, Controlador controlador) {
		JToolBar barraAcciones = controlador.obtenerToolbarAccionesLimpio();
		accionado.mostrarInformacion(barraAcciones);
		accionado.ofrecerAcciones(barraAcciones, juego);
		controlador.escribirEnLog("Seleccionado posicion(x/y):"
				+accionado.obtenerPosicion().getX()+"/"+accionado.obtenerPosicion().getY());
	}

}

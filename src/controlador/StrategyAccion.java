package controlador;

import modelo.Juego;
import visual.Seleccionable;

public interface StrategyAccion {

	public void accionPara(Seleccionable accionado, Juego juego, Controlador controlador);
}

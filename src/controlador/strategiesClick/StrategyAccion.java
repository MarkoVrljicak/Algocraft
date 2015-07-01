package controlador.strategiesClick;

import controlador.Controlador;
import modelo.Juego;
import visual.Seleccionable;

public interface StrategyAccion {

	public void accionPara(Seleccionable accionado, Juego juego, Controlador controlador);
}

package controlador.strategiesClick;

import controlador.Controlador;
import modelo.Juego;
import modelo.unidades.terran.NaveCiencia;
import visual.Seleccionable;

public class StrategyEMP implements StrategyAccion {

	private NaveCiencia nave;

	public StrategyEMP(NaveCiencia nave) {
		this.nave = nave;
	}
	
	@Override
	public void accionPara(Seleccionable accionado, Juego juego,
			Controlador controlador) {
		controlador.realizarEMP(nave, accionado.obtenerPosicion());		

	}

}

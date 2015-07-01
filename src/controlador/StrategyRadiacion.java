package controlador;

import modelo.Juego;
import modelo.unidades.terran.NaveCiencia;
import visual.Seleccionable;

public class StrategyRadiacion implements StrategyAccion {

	private NaveCiencia nave;

	public StrategyRadiacion(NaveCiencia nave) {
		this.nave = nave;
	}
	
	@Override
	public void accionPara(Seleccionable accionado, Juego juego,
			Controlador controlador) {
		controlador.realizarRadiacion(nave, accionado);		

	}


}

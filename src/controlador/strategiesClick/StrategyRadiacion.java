package controlador.strategiesClick;

import modelo.Juego;
import modelo.unidades.Unidad;
import modelo.unidades.terran.NaveCiencia;
import visual.Seleccionable;
import controlador.Controlador;

public class StrategyRadiacion implements StrategyAccion {

	private NaveCiencia nave;

	public StrategyRadiacion(NaveCiencia nave) {
		this.nave = nave;
	}
	
	@Override
	public void accionPara(Seleccionable accionado, Juego juego,
			Controlador controlador) {
		controlador.realizarRadiacion(nave, (Unidad) accionado.getDaniable());		

	}


}

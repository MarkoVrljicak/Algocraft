package controlador.acciones;

import java.awt.event.ActionEvent;

import modelo.unidades.terran.NaveCiencia;
import controlador.strategiesClick.StrategyRadiacion;

public class AccionRadiacion extends AccionesAlgocraft {

	private NaveCiencia nave;

	public AccionRadiacion(NaveCiencia nave) {
		this.nave = nave;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyRadiacion(nave));
		controlador.escribirEnLog("Selecciona terreno para afectar");

	}

}

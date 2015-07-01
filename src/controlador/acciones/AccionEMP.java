package controlador.acciones;

import java.awt.event.ActionEvent;

import modelo.unidades.terran.NaveCiencia;
import controlador.strategiesClick.StrategyEMP;

public class AccionEMP extends AccionesAlgocraft {
	
	private NaveCiencia nave;

	public AccionEMP(NaveCiencia nave) {
		this.nave = nave;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyEMP(nave));
		controlador.escribirEnLog("Selecciona terreno para afectar");

	}

}

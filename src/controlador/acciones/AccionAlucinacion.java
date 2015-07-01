package controlador.acciones;

import java.awt.event.ActionEvent;

import modelo.unidades.protos.AltoTemplario;
import controlador.strategiesClick.StrategyAlucinacion;

public class AccionAlucinacion extends AccionesAlgocraft {

	private AltoTemplario altoTemplario;

	public AccionAlucinacion(AltoTemplario altoTemplario) {
		this.altoTemplario = altoTemplario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyAlucinacion(altoTemplario));
		controlador.escribirEnLog("Seleccione a quien quiere clonar");
	}

}

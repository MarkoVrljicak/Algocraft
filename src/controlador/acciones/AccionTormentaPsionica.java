package controlador.acciones;

import java.awt.event.ActionEvent;

import modelo.unidades.protos.AltoTemplario;
import controlador.strategiesClick.StrategyTormentaPsionica;

public class AccionTormentaPsionica extends AccionesAlgocraft {
	
	private AltoTemplario altoTemplario;

	public AccionTormentaPsionica(AltoTemplario altoTemplario) {
		this.altoTemplario = altoTemplario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyTormentaPsionica(altoTemplario));
		controlador.escribirEnLog("Selecciona terreno para afectar");
	}

}

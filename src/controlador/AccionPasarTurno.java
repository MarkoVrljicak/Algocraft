package controlador;

import java.awt.event.ActionEvent;

public class AccionPasarTurno extends AccionesAlgocraft {

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.pasarTurno();
	}

}

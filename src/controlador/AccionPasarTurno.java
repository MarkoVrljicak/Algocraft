package controlador;

import java.awt.event.ActionEvent;

import modelo.exception.UnidadIncompletaException;

public class AccionPasarTurno extends AccionesAlgocraft {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			controlador.pasarTurno();
		} catch (UnidadIncompletaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

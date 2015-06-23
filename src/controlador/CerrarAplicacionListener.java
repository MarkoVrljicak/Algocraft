package controlador;

import java.awt.event.ActionEvent;

public class CerrarAplicacionListener extends AccionesAlgocraft {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); //cierra la maquina virtual
	}

}

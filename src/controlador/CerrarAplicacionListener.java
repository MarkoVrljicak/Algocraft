package controlador;

import java.awt.event.ActionEvent;

import controlador.acciones.AccionesAlgocraft;

public class CerrarAplicacionListener extends AccionesAlgocraft {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); //cierra la maquina virtual
	}

}

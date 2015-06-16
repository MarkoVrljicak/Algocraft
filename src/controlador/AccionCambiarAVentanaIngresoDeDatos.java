package controlador;

import java.awt.event.ActionEvent;

import visual.Ventanas;

public class AccionCambiarAVentanaIngresoDeDatos extends AccionesAlgocraft {

	public void actionPerformed(ActionEvent e) {
		controlador.cambiarVentanaA(Ventanas.INGRESO_DATOS_JUGADOR);
	}
}

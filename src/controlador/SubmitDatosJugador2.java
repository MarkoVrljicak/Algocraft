package controlador;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controlador.acciones.AccionesAlgocraft;
import modelo.exception.ColorRepetidoExcepcion;
import modelo.exception.MinimoCuatroCaracteresException;
import modelo.exception.NombreRepetidoExcepcion;
import modelo.jugador.Colores;
import modelo.razas.EnumRazas;

public class SubmitDatosJugador2 extends AccionesAlgocraft {

	@Override
	public void actionPerformed(ActionEvent e) {
		EnumRazas razaElegida = controlador.seleccionRaza();
		Colores colorElegido = controlador.seleccionColor();
		String nombreIngresado = controlador.nombreIngresado();
		
		try {
			controlador.ingresarDatosJugador2(nombreIngresado, razaElegida, colorElegido);
			controlador.iniciarJuego();
		} catch (MinimoCuatroCaracteresException | NombreRepetidoExcepcion | ColorRepetidoExcepcion e1) {
			JOptionPane.showMessageDialog(null, "Mal ingreso de Datos","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

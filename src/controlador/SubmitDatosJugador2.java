package controlador;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import modelo.exception.ColorRepetidoExepcion;
import modelo.exception.MinimoCuatroCaracteresException;
import modelo.exception.NombreRepetidoExepcion;
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
		} catch (MinimoCuatroCaracteresException | NombreRepetidoExepcion | ColorRepetidoExepcion e1) {
			JOptionPane.showMessageDialog(null, "Mal ingreso de Datos","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

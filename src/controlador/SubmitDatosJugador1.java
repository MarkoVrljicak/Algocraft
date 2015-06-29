package controlador;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controlador.acciones.AccionesAlgocraft;
import modelo.exception.MinimoCuatroCaracteresException;
import modelo.jugador.Colores;
import modelo.razas.EnumRazas;

public class SubmitDatosJugador1 extends AccionesAlgocraft {

	@Override
	public void actionPerformed(ActionEvent e) {
		EnumRazas razaElegida = controlador.seleccionRaza();
		Colores colorElegido = controlador.seleccionColor();
		String nombreIngresado = controlador.nombreIngresado();
		
		try {
			controlador.ingresarDatosJugador1(nombreIngresado, razaElegida, colorElegido);
			controlador.renovarIngresoDeDatos();
		} catch (MinimoCuatroCaracteresException e1) {
			JOptionPane.showMessageDialog(null, "Mal ingreso de Datos","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

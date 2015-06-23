package visual;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.CerrarAplicacionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaErrorFatal extends JPanel {
	
	String mensajeError;
	public VentanaErrorFatal(String mensajeError) {
		
		this.mensajeError = mensajeError;
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(143, 133, 66, 25);
		botonSalir.addActionListener(new CerrarAplicacionListener());
		setLayout(null);
		add(botonSalir);
		
		JLabel str1 = new JLabel("Error fatal:");
		str1.setHorizontalAlignment(SwingConstants.CENTER);

		str1.setBounds(131, 29, 90, 15);
		add(str1);
		
		JLabel str2 = new JLabel(mensajeError);
		str2.setHorizontalAlignment(SwingConstants.CENTER);
		str2.setBounds(12, 56, 330, 41);
		add(str2);
		
		JLabel str3 = new JLabel("El juego sera cerrado.");
		str2.setHorizontalAlignment(SwingConstants.CENTER);
		str3.setBounds(94, 106, 166, 15);
		add(str3);
		
		
	}
}

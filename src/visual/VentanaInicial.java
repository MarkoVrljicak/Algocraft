package visual;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.AccionCambiarAVentanaIngresoDeDatos;

@SuppressWarnings("serial")
public class VentanaInicial extends JPanel {
	
	public VentanaInicial() {
		super();
		this.setLayout(null);
		this.setVisible(true);
		this.inicializarComponentes();		
	}

	private void inicializarComponentes() {
		JButton btnIniciarJuego = new JButton("Iniciar Juego");
		btnIniciarJuego.addActionListener(new AccionCambiarAVentanaIngresoDeDatos());
		btnIniciarJuego.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIniciarJuego.setBounds(242, 286, 193, 67);
		this.add(btnIniciarJuego);
		
		JLabel lblNewLabel = new JLabel("ALGOCRAFT");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(144, 89, 388, 91);
		this.add(lblNewLabel);
	}
}
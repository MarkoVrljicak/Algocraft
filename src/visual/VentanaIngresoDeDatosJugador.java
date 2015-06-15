package visual;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentanaIngresoDeDatosJugador extends JPanel {

	private JTextField nombreJugador;

	public VentanaIngresoDeDatosJugador(){
		super();
		this.setLayout(null);
		this.setVisible(false);

		inicializarComponentes();
	}

	private void inicializarComponentes() {
		JLabel lblIngresarNombreJugador = new JLabel("Ingresar Nombre Jugador");
		lblIngresarNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngresarNombreJugador.setBounds(27, 117, 243, 39);
		this.add(lblIngresarNombreJugador);

		nombreJugador = new JTextField();
		nombreJugador.setBounds(313, 117, 248, 39);
		this.add(nombreJugador);
		nombreJugador.setColumns(10);

		JLabel lblElegirRaza = new JLabel("Elegir Raza");
		lblElegirRaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElegirRaza.setBounds(27, 218, 243, 39);
		this.add(lblElegirRaza);

		JRadioButton rdbtnTerran = new JRadioButton("Terran");
		rdbtnTerran.setBounds(276, 218, 141, 35);
		this.add(rdbtnTerran);

		JRadioButton rdbtnProtoss = new JRadioButton("Protoss");
		rdbtnProtoss.setBounds(419, 218, 157, 35);
		this.add(rdbtnProtoss);
	}
}

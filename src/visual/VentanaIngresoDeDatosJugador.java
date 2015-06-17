package visual;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.SubmitDatosJugador1;

@SuppressWarnings("serial")
public class VentanaIngresoDeDatosJugador extends JPanel {

	
	private JLabel lblIngresarNombreJugador;
	private JLabel lblElegirRaza;
	private JLabel lblElegirColor;
	public JLabel lblSetUpJugador;
	
	public final ButtonGroup RazaBtnGroup = new ButtonGroup();
	public final ButtonGroup ColorBtnGroup = new ButtonGroup();
	
	public JRadioButton opcionTerran;
	public JRadioButton opcionProtoss;
	public JRadioButton opcionRojo;
	public JRadioButton opcionAzul;
	
	public AbstractButton btnContinuar;
	public JTextField nombreJugador;
	

	public VentanaIngresoDeDatosJugador(){
		super();
		this.setLayout(null);
		this.setVisible(false);

		inicializarComponentes();
	}

	private void inicializarComponentes() {
		lblIngresarNombreJugador = new JLabel("Ingresar nombre jugador");
		lblIngresarNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngresarNombreJugador.setBounds(27, 147, 243, 39);
		this.add(lblIngresarNombreJugador);

		nombreJugador = new JTextField();
		nombreJugador.setBounds(313, 147, 248, 39);
		this.add(nombreJugador);
		nombreJugador.setColumns(10);

		lblElegirRaza = new JLabel("Elegir Raza");
		lblElegirRaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElegirRaza.setBounds(27, 211, 243, 39);
		this.add(lblElegirRaza);

		opcionTerran = new JRadioButton("Terran");
		RazaBtnGroup.add(opcionTerran);
		opcionTerran.setBounds(276, 211, 141, 35);
		this.add(opcionTerran);

		opcionProtoss = new JRadioButton("Protoss");
		RazaBtnGroup.add(opcionProtoss);
		opcionProtoss.setBounds(419, 211, 157, 35);
		this.add(opcionProtoss);
		
		lblElegirColor = new JLabel("Elegir Color");
		lblElegirColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElegirColor.setBounds(27, 271, 243, 39);
		add(lblElegirColor);
		
		opcionRojo = new JRadioButton("Rojo");
		ColorBtnGroup.add(opcionRojo);
		opcionRojo.setBounds(276, 283, 109, 23);
		add(opcionRojo);
		
		opcionAzul = new JRadioButton("Azul");
		ColorBtnGroup.add(opcionAzul);
		opcionAzul.setBounds(419, 283, 109, 23);
		add(opcionAzul);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new SubmitDatosJugador1());
		btnContinuar.setBounds(275, 376, 89, 23);
		add(btnContinuar);
		
		lblSetUpJugador = new JLabel("Set Up Jugador 1");
		lblSetUpJugador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSetUpJugador.setBounds(245, 38, 149, 39);
		add(lblSetUpJugador);
	}
}

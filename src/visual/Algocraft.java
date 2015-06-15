package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Algocraft {

	private JFrame frame;
	private JPanel ventanaInicial;
	private JPanel ventanaDatosJugador;
	private JPanel ventanaJuego;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algocraft window = new Algocraft();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Algocraft() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = 	new JFrame();
		inicializarComponentes();
		
		frame.setBounds(100, 100, 693, 510);
		frame.setTitle("Algocraft");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
	}

	private void inicializarComponentes() {
		frame.getContentPane().setBackground(SystemColor.controlShadow);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		ventanaInicial = new VentanaInicial(this);
		frame.getContentPane().add(ventanaInicial, "name_482171807646183");
			
		
		ventanaDatosJugador = new VentanaIngresoDeDatosJugador();
		frame.getContentPane().add(ventanaDatosJugador, "name_482181740405689");
		ventanaDatosJugador.setVisible(false);
		
		
		ventanaJuego = new JPanel();
		frame.getContentPane().add(ventanaJuego, "name_482183878529208");
		ventanaJuego.setVisible(false);
	}

	public void cambiarVentanaA(Ventanas enumVentana) {
		
		switch(enumVentana){
		case INGRESO_DATOS_JUGADOR:
			ventanaInicial.setVisible(false);
			ventanaJuego.setVisible(false);
			ventanaDatosJugador.setVisible(true);
			break;
		case JUEGO:
			ventanaInicial.setVisible(false);
			ventanaDatosJugador.setVisible(false);
			ventanaJuego.setVisible(true);
			break;
		case VENTANA_INICIAL:
			ventanaDatosJugador.setVisible(false);
			ventanaJuego.setVisible(false);
			ventanaInicial.setVisible(true);
			break;
		}
		
	}
}

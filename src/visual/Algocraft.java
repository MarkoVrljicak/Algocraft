package visual;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelo.Juego;
import controlador.Controlador;

public class Algocraft {
	
	@SuppressWarnings("unused")
	private Controlador controlador;
	private Juego juego;
	private int anchoMapa = 30;
	private int altoMapa = 30;

	private JFrame frame;
	public VentanaInicial ventanaInicial;
	public VentanaIngresoDeDatosJugador ventanaDatosJugador;
	public VentanaJuego ventanaJuego;
	
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
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
	 * @throws IOException 
	 */
	public Algocraft(){
		this.juego = new Juego(anchoMapa,altoMapa);
		this.controlador = new Controlador(this,this.juego);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(){
		frame = new JFrame();
		inicializarComponentes();
		
		frame.setBounds(100, 100, 693, 510);
		frame.setTitle("Algocraft");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	private void inicializarComponentes(){
		frame.getContentPane().setBackground(SystemColor.controlShadow);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		ventanaInicial = new VentanaInicial();
		frame.getContentPane().add(ventanaInicial, "name_482171807646183");
			
		
		ventanaDatosJugador = new VentanaIngresoDeDatosJugador();
		frame.getContentPane().add(ventanaDatosJugador, "name_482181740405689");
		
		
		ventanaJuego = new VentanaJuego(juego);
		frame.getContentPane().add(ventanaJuego, "name_482183878529208");
		
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
	}
}

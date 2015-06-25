package visual;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelo.Juego;
import modelo.exception.DependenciasNoCumplidasException;
import modelo.exception.DestinoInvalidoException;
import modelo.exception.FueraDeLimitesException;
import modelo.exception.GasInsuficienteException;
import modelo.exception.MineralInsuficienteException;
import modelo.exception.PropiedadNoEstaEnJuegoException;
import modelo.exception.RecursosNegativosException;
import modelo.exception.UnidadIncompletaException;
import modelo.factory.edificiosProtoss.EnumEdificiosProtos;
import modelo.factory.edificiosTerran.EnumEdificiosTerran;
import modelo.jugador.Colores;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import modelo.mapa.terrenos.Terrenos;
import modelo.razas.EnumRazas;
import controlador.CerrarAplicacionListener;
import controlador.Controlador;
import controlador.DatosDelGrupo;

public class Algocraft {
	
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
	private JMenu mnAcercaDe;
	private JMenuItem mntmIntegrantes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Algocraft window;
				try {
					window = new Algocraft();
					window.frame.setVisible(true);
				} catch (PropiedadNoEstaEnJuegoException
						| RecursosNegativosException e) {
					(new VentanaErrorFatal("asfasfas")).setVisible(true);
				}	
				
			}
		});
	}

	/**
	 * Create the application.
	 * @throws RecursosNegativosException 
	 * @throws PropiedadNoEstaEnJuegoException 
	 * @throws IOException 
	 */
	public Algocraft() throws PropiedadNoEstaEnJuegoException, RecursosNegativosException{
		try {
			this.juego = new Juego(anchoMapa,altoMapa);
		} catch (FueraDeLimitesException e) {
			(new VentanaErrorFatal("Fuera de limites")).setVisible(true);
		}
		this.controlador = new Controlador(this,this.juego);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws RecursosNegativosException 
	 * @throws PropiedadNoEstaEnJuegoException 
	 * @throws IOException 
	 */
	private void initialize() throws PropiedadNoEstaEnJuegoException, RecursosNegativosException{
		frame = new JFrame();
		//************************************BYPASS INGRESO DATOS********************
		juego.setJugador1("nick", EnumRazas.TERRAN, Colores.AZUL);
		juego.setJugador2("dominic", EnumRazas.PROTOSS, Colores.ROJO);
		juego.iniciarJuego();
		//creo algunas cosas para ver que esten
		try {
			juntarRecursosParaAmbosJugadores(juego);
		} catch (DestinoInvalidoException | FueraDeLimitesException
				| MineralInsuficienteException | GasInsuficienteException
				| DependenciasNoCumplidasException | UnidadIncompletaException e) {
			(new VentanaErrorFatal("asfasfasfa")).setVisible(true);
		}
		//************************************END BYPASS INGRESO DATOS********************
		inicializarComponentes();
		
		frame.setBounds(50, 50, 1200, 700);
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
		mntmSalir.addActionListener(new CerrarAplicacionListener());
		
		mnAcercaDe = new JMenu("Acerca de...");
		menuBar.add(mnAcercaDe);
		
		mntmIntegrantes = new JMenuItem("Integrantes");
		mnAcercaDe.add(mntmIntegrantes);
		mntmIntegrantes.addActionListener(new DatosDelGrupo());
		
		
		//cambiar al poner o sacar bypass
		this.controlador.cambiarVentanaA(Ventanas.JUEGO);
		
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	//*************************************FOR BYPASS(TESTING)*******************************************	

	
	private Coordenada encontrarTerrenoVacio(Terrenos terrenoBuscado,Juego algocraft) 
			throws FueraDeLimitesException{
		for(int i = 1 ; i<=juego.getAncho() ; i++){
			for(int j = 1 ; j<=juego.getAlto() ; j++){
				Coordenada unaPosicion = new Coordenada(i,j);
				Terreno unTerreno = algocraft.obtenerTerreno(unaPosicion);
				if( (unTerreno.getNombre() == terrenoBuscado) && (unTerreno.getContenidoSuelo() == null) )
					return unaPosicion;
			}
		}
		return null; //no se encontro en todo el mapa
	}
	
	private void juntarRecursosParaAmbosJugadores(Juego algocraft) 
			throws DestinoInvalidoException, FueraDeLimitesException, MineralInsuficienteException,
					GasInsuficienteException, DependenciasNoCumplidasException, UnidadIncompletaException, 
					PropiedadNoEstaEnJuegoException, RecursosNegativosException{
		final int muchosTurnos = 100; 
		
		algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosTerran.CENTRO_DE_MINERALES,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosTerran.REFINERIA,
				this.encontrarTerrenoVacio(Terrenos.VOLCAN, algocraft));
		
		algocraft.pasarTurno();
		
		algocraft.construirEn(EnumEdificiosProtos.NEXO_MINERAL,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosProtos.NEXO_MINERAL,
				this.encontrarTerrenoVacio(Terrenos.MINERALES, algocraft));
		algocraft.construirEn(EnumEdificiosProtos.ASIMILADOR, 
				this.encontrarTerrenoVacio(Terrenos.VOLCAN, algocraft));
		
		for (int turnos=0; turnos<=muchosTurnos ; turnos++){
			algocraft.pasarTurno();
		}
		//nota: al salir es el turno del jugador 1
	}
}

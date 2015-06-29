package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import visual.vistas.VistaMapa;
import modelo.Juego;
import modelo.jugador.Jugador;
import controlador.acciones.AccionPasarTurno;

@SuppressWarnings("serial")
public class VentanaJuego extends JPanel implements Observer {

	public VistaMapa mapa;
	private Juego juegoObservado;
	private JToolBar estadisticas;
	private JToolBar acciones;
	private JTextPane log;

	public VentanaJuego(Juego juego){
		super();
		setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		juegoObservado= juego;
		juegoObservado.addObserver(this);
		
		presentarEstadisticas();
		
		acciones = new JToolBar();
		acciones.setFloatable(false);
		acciones.setBounds(970, 10, 200, 400);
		acciones.setOrientation(SwingConstants.VERTICAL);
		add(acciones);
				
		//creo mapa
		mapa = new VistaMapa(juego);
		mapa.setPreferredSize(new Dimension(3000, 3000));
		mapa.setVisible(true);
		//mapa scrolleable
		JScrollPane scrollPaneMapa = new JScrollPane();
		scrollPaneMapa.setViewportView(mapa);
		scrollPaneMapa.setBounds(10, 40, 950, 580);
		add(scrollPaneMapa);
		
		log = new JTextPane();
		JScrollPane scrollPaneLog = new JScrollPane(log);
		scrollPaneLog.setBounds(970, 420, 200, 190);;
		add(scrollPaneLog);
				
	}
	
	//escribe una nueva linea al final del log
	public void escribirEnLog(String texto){
		String pasarLinea = "\n ";
		Document doc = log.getDocument();
		try {
			doc.insertString(doc.getLength(), pasarLinea+texto,null);
		} catch (BadLocationException e) {
			(new VentanaErrorFatal("Error escribiendo en log")).setVisible(true);
		}
	}

	private void presentarEstadisticas() {
		estadisticas = new JToolBar();
		estadisticas.setFloatable(false);
		estadisticas.setBounds(10, 10, 950, 22);
		add(estadisticas);
		
		JButton btnPasarTurno = new JButton("PasarTurno");
		btnPasarTurno.setForeground(Color.RED);
		estadisticas.add(btnPasarTurno);
		btnPasarTurno.addActionListener(new AccionPasarTurno());
		
		JLabel lblInfoNombre = new JLabel("Jugador:");
		estadisticas.add(lblInfoNombre);
		
		JLabel lblNombre = new JLabel("Null");
		estadisticas.add(lblNombre);
		
		JLabel lblInfoMinerales = new JLabel("   Minerales:");
		estadisticas.add(lblInfoMinerales);
		
		JLabel lblMinerales = new JLabel("0");
		estadisticas.add(lblMinerales);
		
		JLabel lblInfoGas = new JLabel("   Gas:");
		estadisticas.add(lblInfoGas);
		
		JLabel labelGas = new JLabel("0");
		estadisticas.add(labelGas);
		
		JLabel lblInfoPoblacion = new JLabel("   Poblacion:");
		estadisticas.add(lblInfoPoblacion);
		
		JLabel lblPoblacionActual = new JLabel("0");
		estadisticas.add(lblPoblacionActual);
		
		JLabel lblSeparador = new JLabel("/");
		estadisticas.add(lblSeparador);
		
		JLabel lblPoblacionMaxima = new JLabel("0");
		estadisticas.add(lblPoblacionMaxima);
		
	}

	private void actualizarEstadisticas() {
		Jugador jugadorActual = juegoObservado.getJugadorActual();
		
		JLabel nombre = (JLabel) estadisticas.getComponent(2);
		nombre.setText(jugadorActual.getNombre());
		
		JLabel minerales = (JLabel) estadisticas.getComponent(4);
		minerales.setText(String.valueOf(jugadorActual.getMineral()));
		
		JLabel gas = (JLabel) estadisticas.getComponent(6);
		gas.setText(String.valueOf(jugadorActual.getGas()));
		
		JLabel poblacionActual = (JLabel) estadisticas.getComponent(8);
		poblacionActual.setText(String.valueOf(jugadorActual.getPoblacionActual()));
		
		JLabel poblacionMaxima = (JLabel) estadisticas.getComponent(10);
		poblacionMaxima.setText(String.valueOf(jugadorActual.getPoblacionMaxima()));
	}
	
	public JToolBar getAcciones(){
		return acciones;
	}

	@Override
	public void update(Observable o, Object arg) {
		actualizarEstadisticas();
		acciones.removeAll();
		acciones.repaint();
	} 

	
	
}

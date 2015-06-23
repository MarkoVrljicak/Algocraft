package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.jugador.Jugador;
import controlador.AccionPasarTurno;

@SuppressWarnings("serial")
public class VentanaJuego extends JPanel implements Observer {

	public VistaMapa mapa;
	private Juego juegoObservado;
	private JToolBar estadisticas;

	public VentanaJuego(Juego juego){
		super();
		setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		juegoObservado= juego;
		juegoObservado.addObserver(this);
		
		presentarEstadisticas();
		
		JToolBar acciones = new JToolBar();
		acciones.setBounds(10, 390, 601, 55);
		add(acciones);
		
		JButton btnPasarTurno = new JButton("PasarTurno");
		btnPasarTurno.addActionListener(new AccionPasarTurno());
		acciones.add(btnPasarTurno);
		
		
		//creo mapa
		mapa = new VistaMapa(juego);
		mapa.setPreferredSize(new Dimension(900, 900));
		mapa.setVisible(true);
		//mapa scrolleable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(mapa);
		scrollPane.setBounds(10, 44, 601, 338);
		add(scrollPane);
		
	}

	private void presentarEstadisticas() {
		estadisticas = new JToolBar();
		estadisticas.setBounds(10, 11, 601, 22);
		add(estadisticas);
		
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
		Jugador jugadorActual = juegoObservado.obtenerJugadorActual();
		
		JLabel nombre = (JLabel) estadisticas.getComponent(1);
		nombre.setText(jugadorActual.getNombre());
		
		JLabel minerales = (JLabel) estadisticas.getComponent(3);
		minerales.setText(String.valueOf(jugadorActual.getMineral()));
		
		JLabel gas = (JLabel) estadisticas.getComponent(5);
		gas.setText(String.valueOf(jugadorActual.getGas()));
		
		JLabel poblacionActual = (JLabel) estadisticas.getComponent(7);
		poblacionActual.setText(String.valueOf(jugadorActual.getPoblacionActual()));
		
		JLabel poblacionMaxima = (JLabel) estadisticas.getComponent(9);
		poblacionMaxima.setText(String.valueOf(jugadorActual.getPoblacionMaxima()));
	}

	@Override
	public void update(Observable o, Object arg) {
		actualizarEstadisticas();		
	}
}

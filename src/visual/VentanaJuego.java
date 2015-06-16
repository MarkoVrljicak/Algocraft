package visual;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class VentanaJuego extends JPanel {

	public VistaMapa mapa;

	public VentanaJuego(){
		super();
		setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		JToolBar estadisticas = new JToolBar();
		estadisticas.setBounds(10, 11, 601, 22);
		add(estadisticas);
		
		JToolBar acciones = new JToolBar();
		acciones.setBounds(10, 390, 601, 55);
		add(acciones);
		
		mapa = new VistaMapa();
		mapa.setPreferredSize(new Dimension(900, 900));
		mapa.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(mapa);
		scrollPane.setBounds(10, 44, 601, 338);
		add(scrollPane);
		
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		
	}
}

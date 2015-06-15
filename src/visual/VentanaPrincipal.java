package visual;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {
		
		iniciarComponentes();
		
		//Asigna un titulo a la barra de titulo
		setTitle("AlgoCraft");
		
		//tamanio de la ventana
		setSize(640,480);
		
		//pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
		
	}

	private void iniciarComponentes() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
	}

}

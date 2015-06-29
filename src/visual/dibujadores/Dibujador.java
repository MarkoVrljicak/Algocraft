package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
//esta y sus clases hijas son mi idea de la version final, uso la otra version por ahora(dibujadorTerreno)
public abstract class Dibujador {

	protected ImageIcon imagen;
	protected static final String pathTexturas ="texturas/";
	
	abstract public JLabel dibujar(Daniable aDibujar, Coordenada posicion);
	
	protected ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}

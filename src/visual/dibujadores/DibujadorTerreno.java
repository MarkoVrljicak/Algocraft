package visual.dibujadores;

import java.util.Set;

import javax.swing.ImageIcon;

import modelo.construcciones.EnumEdificios;

public abstract class DibujadorTerreno{
	
	protected ImageIcon imagen;
	protected static final String pathTexturas ="texturas/";
	
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
	protected Set<EnumEdificios> edificiosConstruibles;
	
	public Set<EnumEdificios> getEdificiosConstruibles(){
		return edificiosConstruibles;
	}
	
	public ImageIcon getImagen(){
		return imagen;
	}
}

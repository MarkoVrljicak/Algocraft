package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorMineral extends Dibujador {
	
	private ImageIcon imagenMineral;
	private static final String pathTexturas ="texturas//";

	public DibujadorMineral(){
		String file;
		file = (pathTexturas + "cristales.png") ;
		imagenMineral=createImageIcon(file,"mineral");
	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagenMineral);
	}

}

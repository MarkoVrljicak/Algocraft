package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorRefineria extends Dibujador {

	private ImageIcon imagenRefineria;

	public DibujadorRefineria(){
		String file;
		file = (pathTexturas + "refineria.png") ;
		imagenRefineria=createImageIcon(file,"");
	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagenRefineria);
	}

}

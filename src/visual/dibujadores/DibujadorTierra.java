package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorTierra extends Dibujador {
	
	private ImageIcon imagenTierra;
	
	public DibujadorTierra(){
		String file;
		file = (pathTexturas + "tierra.png") ;
		imagenTierra =createImageIcon(file,"tierra");
	}


	@Override
	public JLabel dibujar() {
		return new JLabel(imagenTierra);
	}

}

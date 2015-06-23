package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorVolcan extends Dibujador {

	
	private ImageIcon imagenVolcan;

	public DibujadorVolcan(){
		String file;
		
		file = (pathTexturas + "volcan.png") ;
		imagenVolcan=createImageIcon(file,"volcan");

	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagenVolcan);
	}

}

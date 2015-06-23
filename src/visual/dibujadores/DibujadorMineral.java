package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorMineral extends Dibujador {
	
	private ImageIcon imagenMineral;

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

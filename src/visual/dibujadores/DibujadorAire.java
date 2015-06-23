package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorAire extends Dibujador {

	
	private ImageIcon imagenAire;

	public DibujadorAire(){
		String file;
		file =(pathTexturas + "aire.png") ;
		imagenAire=createImageIcon(file,"aire");
		

	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagenAire);
	}
}
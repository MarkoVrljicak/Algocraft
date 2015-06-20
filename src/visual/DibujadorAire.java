package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorAire extends Dibujador {

	
	private ImageIcon imagenAire;
	private static final String pathTexturas ="texturas//";

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
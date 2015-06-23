package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorEspectro extends Dibujador{
	private ImageIcon imagenEspectro;

	public DibujadorEspectro(){
		String file;
		file = (pathTexturas + "espectro.png") ;
		imagenEspectro=createImageIcon(file,"");
	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagenEspectro);
	}
}

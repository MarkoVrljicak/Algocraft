package visual.dibujadores;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujadorCentroMinerales extends Dibujador {

	private ImageIcon imagenCentroMinerales;

	public DibujadorCentroMinerales(){
		String file;
		file = (pathTexturas + "centroMinerales.png") ;
		imagenCentroMinerales=createImageIcon(file,"");
	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagenCentroMinerales);
	}

}

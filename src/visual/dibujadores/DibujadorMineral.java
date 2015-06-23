package visual.dibujadores;

import javax.swing.JLabel;

public class DibujadorMineral extends Dibujador {
	
	public DibujadorMineral(){
		String file;
		file = (pathTexturas + "cristales.png") ;
		imagen = createImageIcon(file,"mineral");
	}


	@Override
	public JLabel dibujar() {
		
		return new JLabel(imagen);
	}

}

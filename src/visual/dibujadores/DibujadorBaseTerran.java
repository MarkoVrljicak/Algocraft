package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import visual.VistaEdificios;


public class DibujadorBaseTerran extends Dibujador {

	public DibujadorBaseTerran(){
		String file;
		file = (pathTexturas + "base_terran.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaEdificios( (Construccion) aDibujar,imagen) ;
	}
}

package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import visual.VistaEdificios;


public class DibujadorPilon extends Dibujador {
	public DibujadorPilon(){
		String file;
		file = (pathTexturas + "pilon.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaEdificios( (Construccion) aDibujar,imagen) ;
	}
}

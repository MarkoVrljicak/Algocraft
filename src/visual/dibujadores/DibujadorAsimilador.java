package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import visual.VistaEdificios;


public class DibujadorAsimilador extends Dibujador {
	public DibujadorAsimilador(){
		String file;
		file = (pathTexturas + "asimilador.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaEdificios( (Construccion) aDibujar,imagen) ;
	}
}

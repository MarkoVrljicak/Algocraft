package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import visual.VistaEdificios;


public class DibujadorNexoMineral extends Dibujador {
	public DibujadorNexoMineral(){
		String file;
		file = (pathTexturas + "nexo_mineral.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaEdificios( (Construccion) aDibujar,imagen) ;
	}
}

package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadAtacante;
import visual.VistaUnidadAtacante;


public class DibujadorZealot extends Dibujador {
	public DibujadorZealot(){
		String file;
		file = (pathTexturas + "zealot.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadAtacante( (UnidadAtacante) aDibujar,imagen) ;
	}
}

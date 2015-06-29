package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadAtacante;
import visual.VistaUnidadAtacante;


public class DibujadorGolliat extends Dibujador{

	public DibujadorGolliat(){
		String file;
		file = (pathTexturas + "golliat.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadAtacante( (UnidadAtacante) aDibujar,imagen) ;
	}

}

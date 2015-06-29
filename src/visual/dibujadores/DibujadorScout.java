package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadAtacante;
import visual.VistaUnidadAtacante;


public class DibujadorScout extends Dibujador {
	public DibujadorScout(){
		String file;
		file = (pathTexturas + "scout.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadAtacante( (UnidadAtacante) aDibujar,imagen) ;
	}

}

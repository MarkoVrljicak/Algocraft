package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadAtacante;
import visual.VistaUnidadAtacante;


public class DibujadorDragon extends Dibujador{

	public DibujadorDragon(){
		String file;
		file = (pathTexturas + "dragon.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadAtacante( (UnidadAtacante) aDibujar,imagen) ;
	}
}

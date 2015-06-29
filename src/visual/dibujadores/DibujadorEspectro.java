package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadAtacante;
import visual.VistaUnidadAtacante;

public class DibujadorEspectro extends Dibujador{
	
	public DibujadorEspectro(){
		String file;
		file = (pathTexturas + "espectro.png") ;
		imagen=createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadAtacante( (UnidadAtacante) aDibujar,imagen) ;
	}
}

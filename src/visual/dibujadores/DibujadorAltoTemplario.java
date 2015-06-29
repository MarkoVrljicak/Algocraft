package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadMagica;
import visual.VistaUnidadesMagicas;


public class DibujadorAltoTemplario extends Dibujador {

	public DibujadorAltoTemplario(){
		String file;
		file = (pathTexturas + "alto_templario.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadesMagicas((UnidadMagica) aDibujar,imagen) ;
	}
}

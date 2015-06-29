package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import visual.VistaCreadorUnidades;


public class DibujadorAcceso extends Dibujador{

	public DibujadorAcceso(){
		String file;
		file = (pathTexturas + "accesso.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new VistaCreadorUnidades((CreadorDeUnidades) aDibujar,imagen) ;
	}

}

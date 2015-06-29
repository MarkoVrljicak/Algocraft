package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import visual.VistaCreadorUnidades;


public class DibujadorBarraca extends Dibujador {

	public DibujadorBarraca(){
		String file;
		file = (pathTexturas + "barraca.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new VistaCreadorUnidades((CreadorDeUnidades) aDibujar,imagen) ;
	}
}

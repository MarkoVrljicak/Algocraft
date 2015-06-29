package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import visual.VistaCreadorUnidades;


public class DibujadorPuertoEstelarTerran extends Dibujador {
	
	public DibujadorPuertoEstelarTerran(){
		String file;
		file = (pathTexturas + "puerto_estelar_terran.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new VistaCreadorUnidades((CreadorDeUnidades) aDibujar,imagen) ;
	}
}

package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import modelo.mapa.Coordenada;
import visual.vistas.VistaCreadorUnidades;


public class DibujadorFabrica extends Dibujador{

	public DibujadorFabrica(){
		String file;
		file = (pathTexturas + "fabrica.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new VistaCreadorUnidades((CreadorDeUnidades) aDibujar,posicion,imagen) ;
	}
}

package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import modelo.mapa.Coordenada;
import visual.vistas.VistaEdificios;


public class DibujadorRefineria extends Dibujador {


	public DibujadorRefineria(){
		String file;
		file = (pathTexturas + "refineria.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new  VistaEdificios( (Construccion) aDibujar,posicion,imagen) ;
	}
}

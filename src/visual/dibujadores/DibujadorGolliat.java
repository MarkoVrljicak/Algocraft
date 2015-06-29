package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadAtacante;
import visual.vistas.VistaUnidadAtacante;


public class DibujadorGolliat extends Dibujador{

	public DibujadorGolliat(){
		String file;
		file = (pathTexturas + "golliat.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new  VistaUnidadAtacante( (UnidadAtacante) aDibujar,posicion,imagen) ;
	}

}

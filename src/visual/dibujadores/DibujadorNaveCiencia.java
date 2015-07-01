package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadMagica;
import visual.vistas.VistaNaveCiencia;


public class DibujadorNaveCiencia extends Dibujador {
	
	public DibujadorNaveCiencia(){
		String file;
		file = (pathTexturas + "nave_ciencia.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new  VistaNaveCiencia((UnidadMagica) aDibujar,posicion,imagen) ;
	}
}

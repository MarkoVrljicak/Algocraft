package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import modelo.mapa.Coordenada;
import visual.vistas.VistaCreadorUnidades;


public class DibujadorPuertoEstelarProtoss extends Dibujador {
	
	public DibujadorPuertoEstelarProtoss(){
		String file;
		file = (pathTexturas + "puerto_estelar_protoss.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new VistaCreadorUnidades((CreadorDeUnidades) aDibujar,posicion,imagen) ;
	}

}

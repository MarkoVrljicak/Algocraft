package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.CreadorDeUnidades;
import modelo.mapa.Coordenada;
import visual.vistas.VistaCreadorUnidades;


public class DibujadorArchivosTemplarios extends Dibujador {

	public DibujadorArchivosTemplarios(){
		String file;
		file = (pathTexturas + "archivos_templarios.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new VistaCreadorUnidades((CreadorDeUnidades) aDibujar, posicion,imagen) ;
	}
}

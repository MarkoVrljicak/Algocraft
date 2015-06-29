package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadMagica;
import visual.vistas.VistaUnidadesMagicas;


public class DibujadorAltoTemplario extends Dibujador {

	public DibujadorAltoTemplario(){
		String file;
		file = (pathTexturas + "alto_templario.png") ;
		imagen = createImageIcon(file,"");
	}
	
	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new  VistaUnidadesMagicas((UnidadMagica) aDibujar, posicion, imagen) ;
	}
}

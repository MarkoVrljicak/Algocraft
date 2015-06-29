package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadTransportadora;
import visual.VistaUnidadTransportadora;


public class DibujadorNaveTransporteTerran extends Dibujador{
	public DibujadorNaveTransporteTerran(){
		String file;
		file = (pathTexturas + "nave_transporte_terran.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadTransportadora((UnidadTransportadora) aDibujar,imagen) ;
	}
}
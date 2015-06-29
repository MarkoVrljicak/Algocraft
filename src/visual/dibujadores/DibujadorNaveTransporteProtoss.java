package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.unidades.UnidadTransportadora;
import visual.VistaUnidadTransportadora;


public class DibujadorNaveTransporteProtoss extends Dibujador{
	public DibujadorNaveTransporteProtoss(){
		String file;
		file = (pathTexturas + "nave_transporte_protoss.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  VistaUnidadTransportadora((UnidadTransportadora) aDibujar,imagen) ;
	}
}

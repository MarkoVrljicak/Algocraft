package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadTransportadora;
import visual.vistas.VistaUnidadTransportadora;


public class DibujadorNaveTransporteProtoss extends Dibujador{
	public DibujadorNaveTransporteProtoss(){
		String file;
		file = (pathTexturas + "nave_transporte_protoss.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new  VistaUnidadTransportadora((UnidadTransportadora) aDibujar,posicion,imagen) ;
	}
}

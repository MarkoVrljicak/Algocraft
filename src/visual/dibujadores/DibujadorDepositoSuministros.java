package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;
import modelo.construcciones.Construccion;
import modelo.mapa.Coordenada;
import visual.vistas.VistaEdificios;


public class DibujadorDepositoSuministros extends Dibujador {

	public DibujadorDepositoSuministros(){
		String file;
		file = (pathTexturas + "deposito_suministro.png") ;
		imagen = createImageIcon(file,"");
	}

	@Override
	public JLabel dibujar(Daniable aDibujar, Coordenada posicion) {
		return new  VistaEdificios( (Construccion) aDibujar,posicion,imagen) ;
	}
}

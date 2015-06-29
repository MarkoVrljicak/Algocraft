package visual.dibujadores;

import javax.swing.JLabel;

import modelo.Interfaces.Daniable;

public class DibujadorVacio extends Dibujador {

	@Override
	public JLabel dibujar(Daniable aDibujar) {
		return new  JLabel("") ;
	}

}

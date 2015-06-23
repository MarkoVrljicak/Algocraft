package visual.dibujadores;

import javax.swing.JLabel;

public class DibujadorUnidadBasico extends Dibujador {

	@Override
	public JLabel dibujar() {
		return new JLabel("UNI");
	}

}

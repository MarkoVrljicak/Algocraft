package visual.dibujadores;

import javax.swing.JLabel;

public class DibujadorVacio extends Dibujador {

	@Override
	public JLabel dibujar() {
		return new JLabel("");
	}

}

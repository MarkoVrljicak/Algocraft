package visual.dibujadores;

import javax.swing.JLabel;

public class DibujadorBarraca extends Dibujador {

	@Override
	public JLabel dibujar() {
		return new JLabel("BAR");
	}

}

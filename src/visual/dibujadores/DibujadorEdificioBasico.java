package visual.dibujadores;

import javax.swing.JLabel;
//solo es provisorio, cambiar por lo que corresponda
public class DibujadorEdificioBasico extends Dibujador {

	@Override
	public JLabel dibujar() {
		return new JLabel("ED");
	}

}

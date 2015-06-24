package controlador;

import java.awt.event.ActionEvent;

import modelo.unidades.Unidad;

public class AccionMoverUnidad extends AccionesAlgocraft {

	private Unidad unidad;

	public AccionMoverUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyMovimiento(unidad));
	}

}

package controlador.acciones;

import java.awt.event.ActionEvent;

import controlador.StrategyMovimiento;
import modelo.unidades.Unidad;

public class AccionMoverUnidad extends AccionesAlgocraft {

	private Unidad unidad;

	public AccionMoverUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyMovimiento(unidad));
		controlador.escribirEnLog(
				"Modo movimiento para:" + unidad.getNombre().toString()
				+"Seleccione posicion a la cual mover");
	}

}

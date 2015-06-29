package controlador.acciones;

import java.awt.event.ActionEvent;

import controlador.StrategyAtacar;
import modelo.unidades.UnidadAtacante;

public class AccionAtacar extends AccionesAlgocraft{

	private UnidadAtacante unidad;

	public AccionAtacar(UnidadAtacante unidad) {
		this.unidad = unidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyAtacar(unidad));
		controlador.escribirEnLog(
				"Modoataque para:" + unidad.getNombre().toString()
				+"\n Seleccionea quien quiere atacar");
	}

}

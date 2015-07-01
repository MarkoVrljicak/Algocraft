package controlador.acciones;

import java.awt.event.ActionEvent;

import controlador.strategiesClick.StrategyAtacar;
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
				"Modo ataque para:" + unidad.getNombre().toString()
				+"\n Seleccione a quien quiere atacar");
	}

}

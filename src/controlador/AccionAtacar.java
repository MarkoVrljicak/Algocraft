package controlador;

import java.awt.event.ActionEvent;

import modelo.unidades.UnidadAtacante;

public class AccionAtacar extends AccionesAlgocraft{

	private UnidadAtacante unidad;

	public AccionAtacar(UnidadAtacante unidad) {
		this.unidad = unidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.setStrategyAccion(new StrategyAtacar(unidad));
	}

}

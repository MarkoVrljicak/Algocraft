package controlador.acciones;

import java.awt.event.ActionEvent;

import controlador.StrategySubirUnidad;
import modelo.unidades.UnidadTransportadora;

public class AccionSubir extends AccionesAlgocraft {
	
	private UnidadTransportadora unidadTransportadora;

	public AccionSubir(UnidadTransportadora unidadTransportadora){
		this.unidadTransportadora = unidadTransportadora;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controlador.setStrategyAccion(new StrategySubirUnidad(unidadTransportadora));
	}

}

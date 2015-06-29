package controlador.acciones;

import java.awt.event.ActionEvent;

import modelo.unidades.Unidad;
import modelo.unidades.UnidadTransportadora;

public class AccionBajar extends AccionesAlgocraft {
	
	private UnidadTransportadora unidadTransportadora;
	private Unidad unidadABajar;

	public AccionBajar(UnidadTransportadora unidadTransportadora,Unidad aBajar){
		this.unidadTransportadora = unidadTransportadora;
		this.unidadABajar = aBajar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.bajarUnidad(unidadTransportadora,unidadABajar);
	}

}

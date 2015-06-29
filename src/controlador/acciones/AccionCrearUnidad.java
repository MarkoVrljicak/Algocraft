package controlador.acciones;

import java.awt.event.ActionEvent;

import modelo.construcciones.CreadorDeUnidades;
import modelo.unidades.Unidades;

public class AccionCrearUnidad extends AccionesAlgocraft {

	private Unidades nombreUnidad;
	private CreadorDeUnidades creador;
		
	public AccionCrearUnidad(Unidades nombreUnidad, CreadorDeUnidades creador) {
		this.nombreUnidad = nombreUnidad;
		this.creador = creador;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controlador.crearUnidad(nombreUnidad,creador);
	}

}

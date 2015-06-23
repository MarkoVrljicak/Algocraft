package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.construcciones.EnumEdificios;
import modelo.mapa.Coordenada;

public class AccionCrearEdificio extends AccionesAlgocraft implements
		ActionListener {
	
	private EnumEdificios nombreEdificio;
	private Coordenada posicion;
	
	public AccionCrearEdificio(EnumEdificios nombreEdificio, Coordenada posicion){
		this.nombreEdificio = nombreEdificio;
		this.posicion = posicion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.construirEn(nombreEdificio,posicion);
	}

}

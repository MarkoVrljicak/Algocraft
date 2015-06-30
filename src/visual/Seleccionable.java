package visual;

import javax.swing.JToolBar;

import modelo.Juego;
import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;

public interface Seleccionable {

	
	public Coordenada obtenerPosicion();
	public void mostrarInformacion(JToolBar barraInformacion);
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego);
	public Daniable getDaniable();
}

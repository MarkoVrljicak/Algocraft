package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadMagica;

@SuppressWarnings("serial")
abstract public class VistaUnidadesMagicas extends VistaUnidades {

	protected UnidadMagica unidadMagica;

	public VistaUnidadesMagicas(UnidadMagica unidad,Coordenada posicion, ImageIcon imagen) {
		super(unidad,posicion, imagen);
		unidadMagica = unidad;
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		super.mostrarInformacion(barraInformacion);
		this.mostrarMagia(barraInformacion);
	}
	
	private void mostrarMagia(JToolBar barraInformacion){
		String magiaActual = String.valueOf(unidadMagica.getMagiaActual());
		String magiaMaxima = String.valueOf(unidadMagica.getMagiaMaxima());
		String magia = "Magia : "+ magiaActual + "/" + magiaMaxima;
		JLabel lblMagia = new JLabel(magia);
		barraInformacion.add(lblMagia);
	}
	
	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		super.ofrecerAcciones(barraAcciones, juego);
		if(unidadPerteneceAJugadorActual(juego)){
			ofrecerMagias(barraAcciones);
		}
	}

	abstract protected void ofrecerMagias(JToolBar barraAcciones);
}

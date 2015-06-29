package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadAtacante;
import controlador.acciones.AccionAtacar;

@SuppressWarnings("serial")
public class VistaUnidadAtacante extends VistaUnidades{

	private UnidadAtacante unidadAtacante;

	public VistaUnidadAtacante(UnidadAtacante unidad,Coordenada posicion, ImageIcon imagen) {
		super(unidad,posicion, imagen);
		this.unidadAtacante = unidad;
	}
	
	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		super.ofrecerAcciones(barraAcciones, juego);
		if(unidadPerteneceAJugadorActual(juego)){
			ofrecerAccionAtacar(barraAcciones);
		}
	}

	private void ofrecerAccionAtacar(JToolBar barraAcciones) {
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new AccionAtacar(unidadAtacante));
		barraAcciones.add(btnAtacar);
	}
}

package visual;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.unidades.UnidadAtacante;
import controlador.AccionAtacar;

@SuppressWarnings("serial")
public class VistaUnidadAtacante extends VistaUnidades{

	private UnidadAtacante unidadAtacante;

	public VistaUnidadAtacante(UnidadAtacante unidad, ImageIcon imagen) {
		super(unidad, imagen);
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

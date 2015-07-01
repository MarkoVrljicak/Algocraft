package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;
import controlador.acciones.AccionMoverUnidad;

@SuppressWarnings("serial")
public abstract class VistaUnidades extends VistaDaniable{

	private Unidad unidad;

	public VistaUnidades(Unidad unidad,Coordenada posicion, ImageIcon imagen){
		super(unidad, posicion, imagen);
		this.unidad = unidad;
	}
	

	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		this.mostrarNombre(barraInformacion);
		super.mostrarInformacion(barraInformacion);
		this.mostrarMovimientosRestantes(barraInformacion);
		this.mostrarCostoTransporte(barraInformacion);
		decorarToolbar(barraInformacion);
	}
	
	private void mostrarNombre(JToolBar barraInformacion) {
		String nombre = "Nombre : "+ (unidad.getNombre().toString());
		JLabel lblnombre = new JLabel(nombre);
		barraInformacion.add(lblnombre);
	}

	private void mostrarMovimientosRestantes(JToolBar barraInformacion) {
		String movimientosRestantes = "Movimientos : "+ String.valueOf(unidad.getMovimientos());
		JLabel lblMovRestantes = new JLabel(movimientosRestantes);
		barraInformacion.add(lblMovRestantes);
	}
	
	private void mostrarCostoTransporte(JToolBar barraInformacion) {
		String costoTransporte = "Peso transporte : "+ String.valueOf(unidad.getPesoTransporte());
		JLabel lblCostoTransporte = new JLabel(costoTransporte);
		barraInformacion.add(lblCostoTransporte);
	}

	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		
		if(unidadPerteneceAJugadorActual(juego))
			ofrecerAccionMovimiento(barraAcciones);
	}

	protected boolean unidadPerteneceAJugadorActual(Juego juego) {
		return (unidad.getColor() == juego.getJugadorActual().getColor());
	}

	private void ofrecerAccionMovimiento(JToolBar barraAcciones) {
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new AccionMoverUnidad(unidad));
		barraAcciones.add(btnMover);
	}

	

}

package visual;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;
import controlador.AccionMoverUnidad;

@SuppressWarnings("serial")
public abstract class VistaUnidades extends JLabel implements Seleccionable{

	private Unidad unidad;

	public VistaUnidades(Unidad unidad, ImageIcon imagen){
		super(imagen);
		this.unidad = unidad;
	}
	
	@Override
	public Coordenada obtenerPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		this.mostrarNombre(barraInformacion);
		this.mostrarVida(barraInformacion);
		this.mostrarMovimientosRestantes(barraInformacion);
	}
	
	private void mostrarNombre(JToolBar barraInformacion) {
		String nombre = "Nombre : "+ (unidad.getNombre().toString());
		JLabel lblnombre = new JLabel(nombre);
		barraInformacion.add(lblnombre);
	}
	
	private void mostrarVida(JToolBar barraInformacion) {
		String vida = "Vida : "+ String.valueOf(unidad.getVida()) + "/" + String.valueOf(unidad.getVitalidadMaxima());
		//TODO vida maxima no se muestra
		JLabel lblVida = new JLabel(vida);
		barraInformacion.add(lblVida);
	}


	private void mostrarMovimientosRestantes(JToolBar barraInformacion) {
		//TODO movimientos restantes no se actualizan
		String movimientosRestantes = "Movimientos restantes : "+ String.valueOf(unidad.getMovimientos());
		JLabel lblMovRestantes = new JLabel(movimientosRestantes);
		barraInformacion.add(lblMovRestantes);
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

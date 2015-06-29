package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import visual.Seleccionable;
import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;
import controlador.acciones.AccionMoverUnidad;

@SuppressWarnings("serial")
public abstract class VistaUnidades extends JLabel implements Seleccionable{

	private Unidad unidad;
	private Coordenada posicion;

	public VistaUnidades(Unidad unidad,Coordenada posicion, ImageIcon imagen){
		super(imagen);
		this.unidad = unidad;
		this.posicion = posicion;
	}
	
	@Override
	public Coordenada obtenerPosicion() {
		return posicion;
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
		String vidaActual = String.valueOf(unidad.getVida());
		String vidaMaxima = String.valueOf(unidad.getVitalidadMaxima());
		String vida = "Vida : "+ vidaActual + "/" + vidaMaxima;
		JLabel lblVida = new JLabel(vida);
		barraInformacion.add(lblVida);
	}


	private void mostrarMovimientosRestantes(JToolBar barraInformacion) {
		String movimientosRestantes = "Movimientos : "+ String.valueOf(unidad.getMovimientos());
		JLabel lblMovRestantes = new JLabel(movimientosRestantes);
		barraInformacion.add(lblMovRestantes);
	}

	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		
		if(unidadPerteneceAJugadorActual(juego))
			ofrecerAccionMovimiento(barraAcciones);
		else{
			JButton auxiliar = new JButton("para que se muestren las estadisticas");
			auxiliar.setVisible(false);
			barraAcciones.add(auxiliar);
		}
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
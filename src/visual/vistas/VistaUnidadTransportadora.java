package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.UnidadTransportadora;
import controlador.acciones.AccionBajar;
import controlador.acciones.AccionSubir;

@SuppressWarnings("serial")
public class VistaUnidadTransportadora extends VistaUnidades {

	private UnidadTransportadora unidadTransportadora;

	public VistaUnidadTransportadora(UnidadTransportadora unidad,Coordenada posicion, ImageIcon imagen) {
		super(unidad,posicion, imagen);
		this.unidadTransportadora = unidad;
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		super.mostrarInformacion(barraInformacion);
		mostrarDatosTransporte(barraInformacion);
		mostrarUnidadesTransportadas(barraInformacion);
	}

	private void mostrarUnidadesTransportadas(JToolBar barraInformacion) {
		String unidades = "Transportadas : ";
		JLabel lblTransportadas = new JLabel(unidades);
		barraInformacion.add(lblTransportadas);
	}

	private void mostrarDatosTransporte(JToolBar barraInformacion) {
		String transporte = "Transporte : "+ String.valueOf(unidadTransportadora.unidadesCargadas()) ;
		JLabel lblTransporte = new JLabel(transporte);
		barraInformacion.add(lblTransporte);
		//completar
	}

	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		super.ofrecerAcciones(barraAcciones, juego);
		if(unidadPerteneceAJugadorActual(juego)){
			ofrecerAccionSubir(barraAcciones);
			ofrecerAccionBajar(barraAcciones);
		}
	}

	private void ofrecerAccionBajar(JToolBar barraAcciones) {
		if(unidadTransportadora.unidadesCargadas()>0){
			JButton btnBajar = new JButton("Bajar");
			btnBajar.addActionListener(new AccionBajar(unidadTransportadora, null));
			barraAcciones.add(btnBajar);
		}
	}

	private void ofrecerAccionSubir(JToolBar barraAcciones) {
		JButton btnSubir = new JButton("Subir");
		btnSubir.addActionListener(new AccionSubir(unidadTransportadora));
		barraAcciones.add(btnSubir);
	}

}

package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;
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
	}

	private void mostrarDatosTransporte(JToolBar barraInformacion) {
		String transporte = "Transportados : "+ String.valueOf(unidadTransportadora.unidadesCargadas()) ;
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
			for(Unidad unidadABajar : unidadTransportadora.getTransportados()){
				String nombre = unidadABajar.getNombre().toString();
				JButton btnBajar = new JButton("Bajar "+nombre);
				btnBajar.addActionListener(new AccionBajar(unidadTransportadora, unidadABajar));
				barraAcciones.add(btnBajar);
			}
		}
	}

	private void ofrecerAccionSubir(JToolBar barraAcciones) {
		JButton btnSubir = new JButton("Subir");
		btnSubir.addActionListener(new AccionSubir(unidadTransportadora));
		barraAcciones.add(btnSubir);
	}

}

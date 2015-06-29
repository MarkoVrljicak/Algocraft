package visual;

import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.construcciones.CreadorDeUnidades;
import modelo.unidades.Unidades;
import controlador.AccionCrearUnidad;


@SuppressWarnings("serial")
public class VistaCreadorUnidades extends VistaEdificios {

	private CreadorDeUnidades creadorUnidades;

	public VistaCreadorUnidades(CreadorDeUnidades edificio,ImageIcon imagen) {
		super(edificio, imagen);
		this.creadorUnidades = edificio;
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		super.mostrarInformacion(barraInformacion);
		this.mostrarUnidadesEnCreacion(barraInformacion);
	}

	private void mostrarUnidadesEnCreacion(JToolBar barraInformacion) {
		if(creadorUnidades.unidadEnCreacion()){
			String unisEnCreacion = "UnidadesEnCreacion: ";
			//TODO pedir unidades en creacion, aniadirlas al label(o labels) junto con tiempo restante
			JLabel lblUnidadesCreacion = new JLabel(unisEnCreacion);
			barraInformacion.add(lblUnidadesCreacion);
		}
	}
	
	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		Set<Unidades> creables = creadorUnidades.getUnidadesCreables();
		String intro = "Crear unidad:";
		JLabel lblExplicacion = new JLabel(intro);
		barraAcciones.add(lblExplicacion);
		for (Unidades nombreUnidad : creables) {
			// TODO mostrar costos
			JButton btnNewButton = new JButton(nombreUnidad.toString());
			btnNewButton.addActionListener(new AccionCrearUnidad(nombreUnidad, creadorUnidades));
			barraAcciones.add(btnNewButton);
		}
	}
}
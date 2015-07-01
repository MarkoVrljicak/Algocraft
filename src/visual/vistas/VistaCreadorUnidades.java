package visual.vistas;

import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.construcciones.CreadorDeUnidades;
import modelo.mapa.Coordenada;
import modelo.unidades.Unidad;
import modelo.unidades.Unidades;
import controlador.acciones.AccionCrearUnidad;


@SuppressWarnings("serial")
public class VistaCreadorUnidades extends VistaEdificios {

	private CreadorDeUnidades creadorUnidades;

	public VistaCreadorUnidades(CreadorDeUnidades edificio,Coordenada posicion,ImageIcon imagen) {
		super(edificio, posicion, imagen);
		this.creadorUnidades = edificio;
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		super.mostrarInformacion(barraInformacion);
		this.mostrarUnidadesEnCreacion(barraInformacion);
		decorarToolbar(barraInformacion);
	}

	private void mostrarUnidadesEnCreacion(JToolBar barraInformacion) {
		if(creadorUnidades.unidadEnCreacion()){
			String unisEnCreacion = "UnidadesEnCreacion: ";
			JLabel lblUnidadesCreacion = new JLabel(unisEnCreacion);
			barraInformacion.add(lblUnidadesCreacion);
			for(Unidad unidadEnCreacion : creadorUnidades.getUnidadesEnCreacion()){
				JLabel lblUnidadEnCreacion = new JLabel(unidadEnCreacion.getNombre().toString());
				barraInformacion.add(lblUnidadEnCreacion);
			}
		}
	}
	
	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		if(creadorUnidades.getDuenio()==juego.getJugadorActual()){
			Set<Unidades> creables = creadorUnidades.getUnidadesCreables();
			String intro = "Crear unidad:";
			JLabel lblExplicacion = new JLabel(intro);
			barraAcciones.add(lblExplicacion);
			for (Unidades nombreUnidad : creables) {
				JButton botonCreador = new JButton(nombreUnidad.toString());
				botonCreador.setToolTipText(this.getRecursosNecesarios(nombreUnidad, creadorUnidades));
				botonCreador.addActionListener(new AccionCrearUnidad(nombreUnidad, creadorUnidades));
				barraAcciones.add(botonCreador);
			}
		}
	}
	
	private String getRecursosNecesarios(Unidades nombreUnidad, CreadorDeUnidades creadorUnidades){
		String gasNecesario = String.valueOf(creadorUnidades.getGasNecesario(nombreUnidad));
		String mineralNecesario = String.valueOf(creadorUnidades.getMineralNecesario(nombreUnidad));
		String mensaje = "<html> costo: <br> gas: " + gasNecesario + " <br> mineral:" + mineralNecesario + "</html>";
		return mensaje;
		
	}
}

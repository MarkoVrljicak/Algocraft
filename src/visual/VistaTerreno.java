package visual;

import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.construcciones.EnumEdificios;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import controlador.AccionCrearEdificio;

@SuppressWarnings("serial")
public class VistaTerreno extends JLabel implements Seleccionable{
	
	private Terreno terreno;

	public VistaTerreno(Terreno terreno, ImageIcon imagen){
		super(imagen);
		this.terreno = terreno;
	}

	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		JLabel lblNombre = new JLabel(terreno.getNombre().toString());
		barraInformacion.add(lblNombre);
	}

	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		Set<EnumEdificios> edificiosProbables = juego.getJugadorActual().getConstruccionesDisponibles();
		//TODO cambiar for, preguntar si se puede construir el edificio antes de ofrecer accion
		for(Iterator<EnumEdificios> it = edificiosProbables.iterator(); it.hasNext();){
			EnumEdificios nombreEdificio = it.next();
			JButton btnNewButton = new JButton(nombreEdificio.toString());
			btnNewButton.addActionListener(new AccionCrearEdificio(nombreEdificio, terreno.getCoordenada()));
			barraAcciones.add(btnNewButton);
		}		
	}

	@Override
	public Coordenada obtenerPosicion() {
		return terreno.getCoordenada();
	}
}

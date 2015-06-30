package visual.vistas;

import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.Interfaces.Daniable;
import modelo.construcciones.EnumEdificios;
import modelo.jugador.Jugador;
import modelo.mapa.Coordenada;
import modelo.mapa.terrenos.Terreno;
import visual.Seleccionable;
import controlador.acciones.AccionCrearEdificio;

@SuppressWarnings("serial")
public class VistaTerreno extends JLabel implements Seleccionable{
	
	private Terreno terreno;
	Set<EnumEdificios> edificios;

	public VistaTerreno(Terreno terreno, ImageIcon imagen, Set<EnumEdificios> edificios){
		super(imagen);
		this.terreno = terreno;
		this.edificios = edificios;
	}

	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		JLabel lblNombre = new JLabel(terreno.getNombre().toString());
		barraInformacion.add(lblNombre);
	}

	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		Set<EnumEdificios> edificiosDisponibles = new HashSet<EnumEdificios>();
		edificiosDisponibles.addAll(juego.getJugadorActual().getConstruccionesDisponibles());
		edificiosDisponibles.retainAll(edificios);
				
		mostrarOpciones(edificiosDisponibles, barraAcciones, juego);
	}
	
	private void mostrarOpciones(Set<EnumEdificios> edificios, JToolBar barraAcciones, Juego juego){
		for(EnumEdificios nombreEdificio : edificios){
			Coordenada coordenada = terreno.getCoordenada();
			JButton botonCreador = new JButton(nombreEdificio.toString());
			botonCreador.setToolTipText(this.getRecursosNecesarios(nombreEdificio, juego.getJugadorActual()));
			botonCreador.addActionListener(new AccionCrearEdificio(nombreEdificio, coordenada));
			barraAcciones.add(botonCreador);
		}		
	}

	private String getRecursosNecesarios(EnumEdificios nombreEdificio, Jugador jugadorActual) {
		String gasNecesario = String.valueOf(jugadorActual.getGasNecesarioParaEdificio(nombreEdificio));
		String mineralNecesario = String.valueOf(jugadorActual.getMineralNecesarioParaEdificio(nombreEdificio));
		String mensaje = "<html> costo: <br> gas: " + gasNecesario + " <br> mineral:" + mineralNecesario + "</html>";
		return mensaje;
	}

	@Override
	public Coordenada obtenerPosicion() {
		return terreno.getCoordenada();
	}

	@Override
	public Daniable getDaniable() {
		return null;
	}
}

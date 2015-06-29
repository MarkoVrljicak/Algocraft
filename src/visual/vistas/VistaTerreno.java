package visual.vistas;

import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import visual.Seleccionable;
import modelo.Juego;
import modelo.construcciones.EnumEdificios;
import modelo.jugador.Jugador;
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
		//TODO Preguntar si se puede construir el edificio antes de ofrecer accion
		// <Marko> Estas seguro? Me parece bien que te ofrezca la opcion aunque despues
		//         no te permita construirlo. Asi funciona en el starcraft.
		//TODO Diferenciar por tipo de terreno
		for(EnumEdificios nombreEdificio : edificiosProbables){
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
}

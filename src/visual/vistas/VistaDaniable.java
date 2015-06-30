package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.Interfaces.Daniable;
import modelo.mapa.Coordenada;
import visual.Seleccionable;

@SuppressWarnings("serial")
public abstract class VistaDaniable  extends JLabel implements Seleccionable{

	private Coordenada posicion;
	private Daniable daniable;

	public VistaDaniable(Daniable daniable,Coordenada posicion, ImageIcon imagen){
		super(imagen);
		this.daniable = daniable;
		this.posicion = posicion;
	}
	
	@Override
	public Daniable getDaniable() {
		return daniable;
	}
	
	@Override
	public Coordenada obtenerPosicion() {
		return posicion;
	}

	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		this.mostrarVida(barraInformacion);
		this.mostrarEscudo(barraInformacion);
		workaroundToolbarBug(barraInformacion);
		
	}

	//TODO resolver el bug de una forma que no aniada un boton nulo vacio
	protected void workaroundToolbarBug(JToolBar barraInformacion) {
		JButton separador = new JButton("para que se muestren las estadisticas");
		separador.setVisible(false);
		barraInformacion.add(separador);
	}

	private void mostrarVida(JToolBar barraInformacion) {
		String vidaActual = String.valueOf(daniable.getVida());
		String vidaMaxima = String.valueOf(daniable.getVidaMaxima());
		String vida = "Vida : "+ vidaActual + "/" + vidaMaxima;
		JLabel lblVida = new JLabel(vida);
		barraInformacion.add(lblVida);
	}
	
	private void mostrarEscudo(JToolBar barraInformacion) {
		if(daniable.getEscudoMaximo() != 0){
			String escudoActual = String.valueOf(daniable.getEscudo());
			String escudoMaximo = String.valueOf(daniable.getEscudoMaximo());
			String escudo = "Escudo : "+ escudoActual + "/" + escudoMaximo;
			JLabel lblEscudo = new JLabel(escudo);
			barraInformacion.add(lblEscudo);
		}
	}

	public abstract void ofrecerAcciones(JToolBar barraAcciones, Juego juego);

}

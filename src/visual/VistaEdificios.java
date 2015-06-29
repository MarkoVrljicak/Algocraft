package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.construcciones.Construccion;
import modelo.mapa.Coordenada;

@SuppressWarnings("serial")
public class VistaEdificios extends JLabel implements Seleccionable{

	private Construccion edificio;

	public VistaEdificios(Construccion edificio, ImageIcon imagen){
		super(imagen);
		this.edificio = edificio;
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
		this.mostrarPoblacionSumada(barraInformacion);
		this.mostrarEnConstruccion(barraInformacion);
	}

	private void mostrarNombre(JToolBar barraInformacion) {
		String nombre = "Nombre : "+ (edificio.getNombre().toString());
		JLabel lblnombre = new JLabel(nombre);
		barraInformacion.add(lblnombre);
	}
	
	private void mostrarVida(JToolBar barraInformacion) {
		String vidaActual = String.valueOf(edificio.getVida());
		String vidaMaxima = String.valueOf(edificio.getVidaMaxima());
		String vida = "Vida : "+ vidaActual + "/" + vidaMaxima;
		JLabel lblVida = new JLabel(vida);
		barraInformacion.add(lblVida);
	}
	
	private void mostrarPoblacionSumada(JToolBar barraInformacion) {
		String pobSumada = "Poblacion sumada: "+ (edificio.getPoblacionSumada());
		JLabel lblPoblacionSumada = new JLabel(pobSumada);
		barraInformacion.add(lblPoblacionSumada);		
	}
	

	private void mostrarEnConstruccion(JToolBar barraInformacion) {
		if(edificio.enConstruccion()){
			String enConstruccion = "Edificio en construccion, tiempo restante:";// TODO obtener tiempo restante
			JLabel lblEnConstruccion = new JLabel(enConstruccion);
			barraInformacion.add(lblEnConstruccion);
		}
	}
	
	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		
	}


}
	
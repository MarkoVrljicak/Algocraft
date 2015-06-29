package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import visual.Seleccionable;
import modelo.Juego;
import modelo.construcciones.Construccion;
import modelo.mapa.Coordenada;

@SuppressWarnings("serial")
public class VistaEdificios extends JLabel implements Seleccionable{

	private Construccion edificio;
	private Coordenada posicion;

	public VistaEdificios(Construccion edificio,Coordenada posicion, ImageIcon imagen){
		super(imagen);
		this.edificio = edificio;
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
		this.mostrarPoblacionSumada(barraInformacion);
		this.mostrarEnConstruccion(barraInformacion);
		JButton separador = new JButton("para que se muestren las estadisticas");
		separador.setVisible(false);
		barraInformacion.add(separador);
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
			
			JLabel lblEnConstruccion = new JLabel("Edificio en construccion:");
			barraInformacion.add(lblEnConstruccion);
			String enConstruccion =  "Tiempo restante:"+ String.valueOf(edificio.getTiempoConstruccion());
			JLabel lblEnConstruccion2 = new JLabel(enConstruccion);
			barraInformacion.add(lblEnConstruccion2);
		}
	}
	
	@Override
	public void ofrecerAcciones(JToolBar barraAcciones, Juego juego) {
		
	}


}
	
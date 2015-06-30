package visual.vistas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.Juego;
import modelo.construcciones.Construccion;
import modelo.mapa.Coordenada;

@SuppressWarnings("serial")
public class VistaEdificios extends VistaDaniable{

	private Construccion edificio;

	public VistaEdificios(Construccion edificio,Coordenada posicion, ImageIcon imagen){
		super(edificio,posicion,imagen);
		this.edificio = edificio;
		
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		this.mostrarNombre(barraInformacion);
		super.mostrarInformacion(barraInformacion);
		this.mostrarPoblacionSumada(barraInformacion);
		this.mostrarEnConstruccion(barraInformacion);
		workaroundToolbarBug(barraInformacion);
	}

	private void mostrarNombre(JToolBar barraInformacion) {
		String nombre = "Nombre : "+ (edificio.getNombre().toString());
		JLabel lblnombre = new JLabel(nombre);
		barraInformacion.add(lblnombre);
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
	
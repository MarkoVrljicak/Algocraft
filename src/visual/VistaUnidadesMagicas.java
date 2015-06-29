package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import modelo.unidades.UnidadMagica;

@SuppressWarnings("serial")
public class VistaUnidadesMagicas extends VistaUnidades {

	private UnidadMagica unidadMagica;

	public VistaUnidadesMagicas(UnidadMagica unidad, ImageIcon imagen) {
		super(unidad, imagen);
		unidadMagica = unidad;
	}
	
	@Override
	public void mostrarInformacion(JToolBar barraInformacion) {
		super.mostrarInformacion(barraInformacion);
		this.mostrarMagia(barraInformacion);
	}
	
	private void mostrarMagia(JToolBar barraInformacion){
		String magiaActual = String.valueOf(unidadMagica.getMagiaActual());
		String magiaMaxima = String.valueOf(unidadMagica.getMagiaMaxima());
		String magia = "Magia : "+ magiaActual + "/" + magiaMaxima;
		JLabel lblMagia = new JLabel(magia);
		barraInformacion.add(lblMagia);
	}
	
	//TODO mostrar magias y triarlas
}
